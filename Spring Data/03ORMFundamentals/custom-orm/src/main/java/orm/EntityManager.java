package orm;

import annotation.Column;
import annotation.Entity;
import annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primaryKey = this.getIdColumn(entity.getClass());
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);
        if (value == null || (long) value <= 0) {
            return doInsert(entity, primaryKey);
        }
        return doUpdate(entity, primaryKey);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, "");
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s %s", tableName, where);
        ResultSet resultSet = getResultSet(query, table, where);
        List<E> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSetToEntity(table, resultSet));
        }
        return result;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, "");
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s %s LIMIT 1", tableName, where);
        ResultSet resultSet = getResultSet(query, table, where);
        resultSet.next();
        return resultSetToEntity(table, resultSet);
    }

    private ResultSet getResultSet(String query, Class<E> table, String where) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    private E resultSetToEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, SQLException {
        E entity = table.getDeclaredConstructor().newInstance();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field.set(entity, getProperValue(resultSet, field.getAnnotation(Column.class).name(), field.getType()));
        }
        return entity;
    }

    private <T> T getProperValue(ResultSet resultSet, String name, Class<T> clazz) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (clazz.isAssignableFrom(LocalDate.class)) {
            return (T) LocalDate.parse(resultSet.getObject(name).toString());
        }
        Object object = resultSet.getObject(name);
        return (T) object;
    }

    private Field getIdColumn(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() ->
                        new UnsupportedOperationException("Entity does not have primary key"));
    }

    private boolean doInsert(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<Field> fields = getColumns(entity);
        String columnNames = getColumnNames(fields);
        String columnValues = getColumnValues(fields, entity);
        String insertQuery = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, columnNames, columnValues);
        return connection.prepareStatement(insertQuery).execute();
    }

    private boolean doUpdate(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<Field> fields = getColumns(entity);
        String setColumnValues = getColumnNamesAndValues(fields, entity);
        String updateQuery = String.format("UPDATE %s SET %s WHERE %s = %s",
                tableName, setColumnValues, primaryKey.getName(), primaryKey.get(entity));
        return connection.prepareStatement(updateQuery).execute();
    }

    private List<Field> getColumns(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private String getTableName(Class<?> clazz) {
        return clazz.getAnnotation(Entity.class).name();
    }

    private String getColumnNames(List<Field> fields) {
        return fields
                .stream()
                .map(field -> field.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getColumnValues(List<Field> fields, E entity) throws IllegalAccessException {
        List<String> values = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(entity);
            String strValue = getStringDependingType(value);
            values.add(strValue);
        }

        return String.join(", ", values);
    }

    private String getColumnNamesAndValues(List<Field> fields, E entity) throws IllegalAccessException {
        List<String> statements = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getAnnotation(Column.class).name();
            Object value = field.get(entity);
            String strValue = getStringDependingType(value);
            statements.add(String.format("%s = %s", columnName, strValue));
        }
        return String.join(", ", statements);
    }

    private String getStringDependingType(Object value) {
        String strValue = value.toString();
        if ((value instanceof String)
                || (value instanceof LocalDate)) {
            strValue = String.format("'%s'", strValue);
        }
        return strValue;
    }
}
