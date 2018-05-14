package com.jet.edu.InnerAPI;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.sql.*;
import java.util.Map;

public class DBWriter implements JavaDelegate {
    private static final String URL = "jdbc:oracle:thin:@10.38.184.55:1521:myDatabase";
    private static final String USERNAME = "balalykin";
    private static final String PASSWORD = "balalykin";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        final String INSERT_INTO = "INSERT INTO BALALYKIN.USERS(FIRSTNAME, SURNAME, AGE) VALUES(?,?,?)";
        Map<String, Object> users = delegateExecution.getVariables();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, String.valueOf(users.get("name")));
            preparedStatement.setString(2, String.valueOf(users.get("surname")));
            preparedStatement.setInt(3, Integer.parseInt(users.get("age").toString()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
