package com.jet.edu.InnerAPI;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.sql.*;
import java.util.Map;

public class DBWriter /*implements JavaDelegate*/ {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:myDatabase";
    private static final String USERNAME = "mrbalalykin";
    private static final String PASSWORD = "mrbalalykin";

    //@Override
    public static void execute(DelegateExecution delegateExecution) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        final String INSERT_INTO = "INSERT INTO MRBALALYKIN.USERS(FIRSTNAME, SURNAME, AGE) VALUES(?,?,?)";
        //Map<String, Object> users = delegateExecution.getVariables();

        /*Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("connection");*/

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, "aa"/*String.valueOf(users.get("name"))*/);
            preparedStatement.setString(2, "bb"/*String.valueOf(users.get("surname"))*/);
            preparedStatement.setInt(3, 33/*(Integer) users.get("age")*/);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            execute(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
