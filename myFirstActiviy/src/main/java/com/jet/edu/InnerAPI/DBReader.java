package com.jet.edu.InnerAPI;

import java.sql.*;

public class DBReader {
    private static final String URL = "jdbc:oracle:thin:@10.38.184.55:1521:myDatabase";
    private static final String USERNAME = "balalykin";
    private static final String PASSWORD = "balalykin";

    private void readFromOracleBD() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        final String GET_ALL = "SELECT * FROM BALALYKIN.USERS";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String firstName = resultSet.getString("FIRSTNAME");
                String surName = resultSet.getString("SURNAME");
                int age = resultSet.getInt("AGE");

                System.out.println("firstName = " + firstName);
                System.out.println("surName = " + surName);
                System.out.println("age = " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
