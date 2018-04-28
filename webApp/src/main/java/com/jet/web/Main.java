package com.jet.web;

import com.jet.edu.OuterAPI.OuterAPI;
import com.jet.edu.OuterAPI.StandartAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Main {

    static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    static OuterAPI start = (OuterAPI) context.getBean("api");

    public static void main(String[] args) {
        start.start();
    }
}
