package com.jet.edu.service;

import com.jet.edu.api.Reader;
import com.jet.edu.impl.OracleReader;
import com.jet.edu.users.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseReaderService {
    private ApplicationContext context;
    private Reader reader;

    public DatabaseReaderService() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        reader = context.getBean("oracleReader", OracleReader.class);
    }

//    reader reader = new OracleReader();

    public List<User> readFromOracleBD() {
        List<User> users;
        users = reader.readFromBD();
        return users;
    }

    /*public static void main(String[] args) {
        new DatabaseReaderService();
        System.out.println(readFromOracleBD());
    }*/
}
