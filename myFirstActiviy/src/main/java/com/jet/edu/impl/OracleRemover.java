package com.jet.edu.impl;

import com.jet.edu.api.Remover;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class OracleRemover implements Remover {
    private ApplicationContext context;
    private DataSource dataSource;
//DataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@10.38.184.55:1521:myDatabase", "balalykin","balalykin");

    public OracleRemover() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        dataSource = context.getBean("dataSource", DataSource.class);
    }


    @Override
    public void removeFromBD() {
        final String REMOVE_ALL = "TRUNCATE TABLE BALALYKIN.USERS";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ALL)) {
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
