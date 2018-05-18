package com.jet.edu.service;

import com.jet.edu.api.Remover;
import com.jet.edu.impl.OracleRemover;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DatabaseRemoverService {
    private ApplicationContext context;
    private Remover remover;


    public DatabaseRemoverService() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        remover = context.getBean("oracleRemover", OracleRemover.class);
    }
//    remover remover = new OracleRemover();

    public void removeFromOracleBD() {
        remover.removeFromBD();
    }


    /*public static void main(String[] args) {
        new DatabaseRemoverService();
        removeFromOracleBD();
    }*/
}
