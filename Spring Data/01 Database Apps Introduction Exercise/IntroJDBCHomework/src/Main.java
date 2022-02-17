import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DATABASE = "minions_db";
    private static int counter = 0;
    private static Connection connection;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("2. Get Villain's Names");
        System.out.println("3. Get Minion Names");
        System.out.println("4. Add Minion");
        System.out.println("5. Change Town Names Casing");
        System.out.println("6. Remove Villain");
        System.out.println("7. Print All Minion Names");
        System.out.println("8. Increase Minions Age");
        System.out.println("9. Increase Age Stored Procedure");
        int problem = readIntFromConsole("Choose the problem number: ");
        switch (problem) {
            case 2 -> getVillainsNames();
            case 3 -> getMinionNames();
            case 4 -> addMinions();
            case 5 -> changeTownNamesCasing();
            case 6 -> removeVillain();
            case 7 -> {
                System.out.println(ANSI_RED
                        + "You have to reload fresh database to get the answer as in problem!!!"
                        + ANSI_RESET);
                printAllMinionNames();
            }
            case 8 -> increaseMinionsAge();
            case 9 -> {
                System.out.println(ANSI_RED
                        + "You have to run SQL script to create stored procedure before run code!!!"
                        + ANSI_RESET);
                increaseAgeStoredProcedure();
            }
            default -> System.out.printf("Problem %d doesn't exist!%n", problem);
        }
    }

    /**
     * Problem 2. Get Villains’ Names
     *
     * @throws IOException
     */
    private static void getVillainsNames() throws IOException, SQLException {
        initializeConnection();
        try (Statement statement = Main.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT v.`name`, COUNT(DISTINCT mv.minion_id) AS minions_count " +
                            "FROM villains as v " +
                            "         JOIN minions_villains as mv on v.id = mv.villain_id " +
                            "GROUP BY mv.villain_id " +
                            "HAVING minions_count > 15 " +
                            "ORDER BY minions_count DESC;");
            while (resultSet.next()) {
                printVillainsWithMinionsCount(resultSet);
            }
        }

    }

    private static void printVillainsWithMinionsCount(ResultSet resultSet) throws SQLException {
        String villainName = resultSet.getString(1);
        int minionsCount = resultSet.getInt(2);
        System.out.printf("%s %d%n", villainName, minionsCount);
    }

    /**
     * Problem 3. Get Minion Names
     *
     * @throws IOException
     */
    private static void getMinionNames() throws IOException {
        Properties properties = getUsernameAndPassword();
        try (Connection connection =
                     DriverManager.getConnection(CONNECTION_STRING + DATABASE, properties)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT v.name, m.name, m.age " +
                    "FROM villains AS v " +
                    "    JOIN minions_villains AS mv ON mv.villain_id = v.id " +
                    "    JOIN minions m ON m.id = mv.minion_id " +
                    "WHERE v.id = ?")) {

                int villainId = readIntFromConsole("Enter villain id: ");
                statement.setInt(1, villainId);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    printMinionData(resultSet);
                }

                if (counter == 0) {
                    System.out.printf("No villain with ID %d exists in the database.%n", villainId);
                }
            }
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static void printMinionData(ResultSet resultSet) throws SQLException {
        if (counter == 0) {
            String villainName = resultSet.getString(1);
            System.out.printf("Villain: %s%n", villainName);
            counter++;
        }

        String minionName = resultSet.getString(2);
        int minionAge = resultSet.getInt(3);
        System.out.printf("%d. %s %d%n", counter++, minionName, minionAge);
    }

    /**
     * problem 4. Add Minion
     *
     * @throws IOException
     * @throws SQLException
     */
    private static void addMinions() throws IOException, SQLException {
        initializeConnection();
        Minion minion = new Minion();
        String villainName = "";

        for (int i = 0; i < 2; i++) {
            String[] tokens = readStringFromConsole("").split("\\s+");
            if (tokens[0].equals("Minion:")) {
                minion = new Minion(Arrays.copyOfRange(tokens, 1, tokens.length));
            } else {
                villainName = tokens[1];
            }
        }

        minion.townId = insertTownIfNotExist(minion.town);
        minion.id = insertMinionIfNotExist(minion);
        int villainId = insertVillainIfNotExist(villainName);
        if (insertMinionToVillain(minion.id, villainId)) {
            System.out.printf("Successfully added %s to be minion of %s%n", minion.name, villainName);
        }

    }

    /**
     * 5. Change Town Names Casing
     *
     * @throws SQLException
     * @throws IOException
     */
    private static void changeTownNamesCasing() throws SQLException, IOException {
        initializeConnection();
        String countryName = readStringFromConsole("Enter country name: ");
        int affectedTownsCount = updateTowns(countryName);
        if (affectedTownsCount > 0) {
            System.out.printf("%d town names were affected.%n", affectedTownsCount);
            List<String> affectedTownsNames = getAffectedTownNames(countryName);
            System.out.println(affectedTownsNames);
        } else {
            System.out.println("No town names were affected.");
        }
    }

    private static int updateTowns(String countryName) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");
        statement.setString(1, countryName);
        int affectedRecordsCount = statement.executeUpdate();
        return affectedRecordsCount;
    }

    private static List<String> getAffectedTownNames(String countryName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name " +
                        "FROM towns " +
                        "WHERE country = ?");
        statement.setString(1, countryName);
        List<String> townsNames = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            townsNames.add(resultSet.getString(1));
        }
        return townsNames;
    }

    /**
     * 6. Remove Villain
     *
     * @throws SQLException
     * @throws IOException
     */
    private static void removeVillain() throws SQLException, IOException {
        initializeConnection();
        int id = readIntFromConsole("Enter villain id: ");
        String villainName = findEntityNameById("villains", id);
        if (villainName != null) {
            int releasedMinionsCount = releaseVillainsMinions(id);
            if (deleteVillain(id)) {
                System.out.printf("%s was deleted%n", villainName);
                System.out.printf("%d minions released%n", releasedMinionsCount);
            }
        } else {
            System.out.println("No such villain was found");
        }
    }

    private static int releaseVillainsMinions(int id) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    private static boolean deleteVillain(int id) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("DELETE FROM villains WHERE id = ?");
        statement.setInt(1, id);
        return statement.executeUpdate() > 0;
    }

    /**
     * 7. Print All Minion Names
     * You have to reload fresh database to get the answer as in problem!!!
     *
     * @throws SQLException
     * @throws IOException
     */
    private static void printAllMinionNames() throws SQLException, IOException {
        initializeConnection();
        PreparedStatement statement = connection
                .prepareStatement("SELECT name FROM minions");
        ArrayDeque<String> minionsNames = new ArrayDeque<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            minionsNames.add(resultSet.getString(1));
        }

        int counter = 0;
        while (!minionsNames.isEmpty()) {
            System.out.println(counter++ % 2 == 0 ? minionsNames.pollFirst() : minionsNames.pollLast());
        }
    }

    /**
     * 8. Increase Minions Age
     *
     * @throws SQLException
     * @throws IOException
     */
    private static void increaseMinionsAge() throws SQLException, IOException {
        initializeConnection();
        try {
            String ids = consoleReadIds();
            String query = String.format("UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id IN(%s)", ids);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();

            statement = connection.prepareStatement("SELECT name, age FROM minions");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%s %d%n",
                        resultSet.getString(1),
                        resultSet.getInt(2));
            }
        } catch (NumberFormatException pe) {
            System.out.println(ANSI_RED + "Invalid input");
            System.out.println(pe.getMessage() + ANSI_RESET);
        }
    }

    private static String consoleReadIds() throws IOException {
        return Arrays.stream(readStringFromConsole("Enter minions IDs separated by space: ")
                        .split("\\s+"))
                .map(Integer::parseInt)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    /**
     * 9. Increase Age Stored Procedure
     *
     * @throws SQLException
     * @throws IOException
     * @apiNote You have to run SQL script to create stored procedure before run code!!!
     * -- The query for creation ot the stored procedure for problem 9 Increase Age Stored Procedure
     * DROP procedure IF EXISTS `minions_db`.`usp_get_older`;
     *
     * DELIMITER $$
     * USE `minions_db`$$
     * CREATE PROCEDURE `usp_get_older`(minion_id INT)
     * BEGIN
     * UPDATE minions SET age = age + 1 WHERE id = minion_id;
     * END$$
     *
     * DELIMITER ;
     * ;
     */
    private static void increaseAgeStoredProcedure() throws SQLException, IOException {
        initializeConnection();
        int minionId = readIntFromConsole("Enter minion id: ");
        CallableStatement statement = connection.prepareCall("CALL usp_get_older(?)");
        statement.setInt(1, minionId);
        int affectedRecords = statement.executeUpdate();
        printRecordsAffectedMessage(affectedRecords);
    }

    private static void printRecordsAffectedMessage(int affectedRecords) {
        String messageTemplate = affectedRecords > 1 ? "%d records affected%n" : "%d record affected%n";
        System.out.printf(messageTemplate, affectedRecords);
    }

    private static boolean insertMinionToVillain(int minionId, int villainId) throws SQLException {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) VALUES (?,?)")) {
            insertStatement.setInt(1, minionId);
            insertStatement.setInt(2, villainId);
            int insertedRecordsCount = insertStatement.executeUpdate();
            return insertedRecordsCount > 0;
        }
    }

    private static int insertVillainIfNotExist(String villainName) throws SQLException {
        int villainId = findEntityIdByName("villains", villainName);
        if (villainId == 0) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO villains(`name`) VALUES (?)")) {
                statement.setString(1, villainName);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    villainId = findEntityIdByName("villains", villainName);
                    System.out.printf("Villain %s was added to the database.%n", villainName);
                }
            }
        }

        return villainId;
    }

    private static int insertMinionIfNotExist(Minion minion) throws SQLException {
        int minionId = findEntityIdByName("minions", minion.name);
        if (minionId == 0) {
            try (PreparedStatement statement =
                         connection.prepareStatement("INSERT INTO minions(`name`, age, town_id) VALUES (?,?,?)")) {
                statement.setString(1, minion.name);
                statement.setInt(2, minion.age);
                statement.setInt(3, minion.townId);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    minionId = findEntityIdByName("minions", minion.name);
                }
            }
        }

        return minionId;
    }

    private static int insertTownIfNotExist(String townName) throws SQLException {
        int townId = findEntityIdByName("towns", townName);
        if (townId == 0) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO towns(`name`) VALUES (?)")) {
                statement.setString(1, townName);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    townId = findEntityIdByName("towns", townName);
                    System.out.printf("Town %s was added to the database.%n", townName);
                }
            }
        }

        return townId;
    }

    private static String findEntityNameById(String entityName, int id) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", entityName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        String name = null;
        if (resultSet.next()) {
            name = resultSet.getString(1);
        }

        return name;
    }

    private static int findEntityIdByName(String entityName, String name) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", entityName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        int resultId = 0;
        if (resultSet.next()) {
            resultId = resultSet.getInt(1);
        }

        return resultId;
    }

    private static Properties getUsernameAndPassword() throws IOException {
        Properties properties = new Properties();
        String user = readStringFromConsole("Enter user: ");
        properties.setProperty("user", user);
        String password = readStringFromConsole("Enter password: ");
        properties.setProperty("password", password);
        return properties;
    }

    private static void initializeConnection() throws IOException, SQLException {
        Properties properties = getUsernameAndPassword();
        connection = DriverManager.getConnection(CONNECTION_STRING + DATABASE, properties);
    }

    private static String readStringFromConsole(String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }

    private static int readIntFromConsole(String message) throws IOException {
        return Integer.parseInt(readStringFromConsole(message));
    }

    static class Minion {

        private int id;
        private String name;
        private int age;
        private int townId;
        private String town;

        public Minion() {
        }

        public Minion(String[] tokens) {
            this.name = tokens[0];
            this.age = Integer.parseInt(tokens[1]);
            this.town = tokens[2];
        }
    }

}
