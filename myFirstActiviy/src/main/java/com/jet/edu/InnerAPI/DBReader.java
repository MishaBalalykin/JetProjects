package com.jet.edu.InnerAPI;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBReader {
    private static final String URL = "jdbc:oracle:thin:@10.38.184.55:1521:myDatabase";
    private static final String USERNAME = "balalykin";
    private static final String PASSWORD = "balalykin";

    public List<User> readFromOracleBD() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        List<User> users = new ArrayList<>();
        final String GET_ALL = "SELECT * FROM BALALYKIN.USERS";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(new User(resultSet.getString("FIRSTNAME"),
                        resultSet.getString("SURNAME"), resultSet.getString("AGE")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
