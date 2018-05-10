package com.jet.edu.OuterAPI;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class OracleWriter implements DBWriter {
    @Override
    public void start(HashMap users) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProcessEngine processEngine = (ProcessEngine) applicationContext.getBean("processEngine");

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
    }
}
