package database.exam;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            statement.execute("INSERT INTO animals(animal_name, animal_desc) VALUES ('name', 'desc');");//для вставки

            int numChanges = statement.executeUpdate("UPDATE animals SET animal_name = 'Cat', animal_desc = 'Desc' WHERE id = 1;");//для апдейта

            ResultSet resultSet = statement.executeQuery("SELECT * FROM animals;");// для выборки

            //region start
            statement.addBatch("INSERT INTO animals(animal_name, animal_desc) VALUES ('Dog', 'desc');");
            statement.addBatch("INSERT INTO animals(animal_name, animal_desc) VALUES ('Elefant', 'desc');");
            statement.addBatch("INSERT INTO animals(animal_name, animal_desc) VALUES ('Lion', 'desc');");

            statement.executeBatch(); // если надо выполнить несколько запросов за одну команду execute
            statement.clearBatch(); // затирает старые запросы из  бэтчей
            //endregion
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
