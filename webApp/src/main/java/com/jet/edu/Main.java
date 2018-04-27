package com.jet.edu;

import org.activiti.engine.RuntimeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public void start() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RuntimeService runtimeService = (RuntimeService) applicationContext.
                getBean("runtimeService");
        runtimeService.startProcessInstanceByKey("myFirstActivity");
    }
}
