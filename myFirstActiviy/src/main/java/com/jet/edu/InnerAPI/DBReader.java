package com.jet.edu.InnerAPI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private DataSource dataSource = (DataSource) context.getBean("dataSource");

    public List<User> readFromOracleBD() throws ClassNotFoundException {
        List<User> users = new ArrayList<>();
        final String GET_ALL = "SELECT * FROM BALALYKIN.USERS";

        try (Connection connection = dataSource.getConnection();
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