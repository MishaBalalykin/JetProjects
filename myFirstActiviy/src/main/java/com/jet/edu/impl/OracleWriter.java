package com.jet.edu.impl;

import com.jet.edu.api.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@Component
public class OracleWriter implements Writer {
    private static final String INSERT_INTO = "INSERT INTO BALALYKIN.USERS(FIRSTNAME, SURNAME, AGE) VALUES(?,?,?)";
    private ApplicationContext context;
    private DataSource dataSource;
//DataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@10.38.184.55:1521:myDatabase", "balalykin","balalykin");

    public OracleWriter() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        dataSource = context.getBean("dataSource", DataSource.class);
    }

    @Override
    public void write(Map users) {
        try (Connection connection = dataSource.getConnection();
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
