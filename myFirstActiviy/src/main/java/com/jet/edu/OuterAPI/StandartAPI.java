package com.jet.edu.OuterAPI;

import com.jet.edu.OuterAPI.OuterAPI;
import org.activiti.engine.RuntimeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component(value = "api")
public class StandartAPI implements OuterAPI {
    @Override
    public void start() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RuntimeService runtimeService = (RuntimeService) applicationContext.
                getBean("runtimeService");
        runtimeService.startProcessInstanceByKey("myFirstActivity");
    }

}
