import entities.User;
import orm.DbContext;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "", "custom-orm");
        Connection connection = MyConnector.getConnection();
        DbContext<User> dbContext = new EntityManager(connection);

        List<User> users = List.of(
                new User("Pesho", 15, LocalDate.now()),
                new User("Gosho", 25, LocalDate.now()),
                new User("Dancho", 50, LocalDate.now()),
                new User("Niki", 35, LocalDate.now()));
        for (User user : users) {
            dbContext.persist(user);
        }

        Iterable<User> usersCollection = dbContext.find(User.class);

        for (User user : usersCollection) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println(dbContext.findFirst(User.class, "WHERE id=3"));

        System.out.println();
        System.out.println(dbContext.findFirst(User.class));

        System.out.println();
        System.out.println(dbContext.find(User.class, "WHERE id=4"));
        connection.close();
    }
}
