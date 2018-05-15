package com.jet.edu.OuterAPI;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OracleWriter implements DBWriter {
    @Override
    public void start(Map users) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ProcessEngine processEngine = (ProcessEngine) applicationContext.getBean("processEngine");

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", users);
    }

    /*public static void main(String[] args) {
        Map<String, Object> users = new HashMap<>();
        users.put("surname", "balalykin");
        users.put("name", "misha");
        users.put("age", "22");
        start(users);
    }*/
}
