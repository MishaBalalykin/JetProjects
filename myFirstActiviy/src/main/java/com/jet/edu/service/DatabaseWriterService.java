package com.jet.edu.service;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseWriterService {
    private ProcessEngine processEngine;
    private ApplicationContext context;

    public DatabaseWriterService() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        processEngine = context.getBean("processEngine", ProcessEngine.class);
    }


    public void write(Map<String, Object> users) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("myProcess", users);
    }


    /*public static void main(String[] args) {
        new DatabaseWriterService();
        write(new HashMap<String, Object>());
    }*/
}
