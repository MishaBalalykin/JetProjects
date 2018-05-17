package com.jet.edu.OuterAPI;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OracleWriter implements DBWriter {
    @Override
    public void start(Map users) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ProcessEngine processEngine = (ProcessEngine) applicationContext.getBean("processEngine");

        RuntimeService runtimeService = processEngine.getRuntimeService();

        runtimeService.startProcessInstanceByKey("myProcess", users);
    }
}
