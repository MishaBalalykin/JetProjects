package com.jet.edu.OuterAPI;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class Test {
    public static String test(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ProcessEngine processEngine = (ProcessEngine) applicationContext.getBean("processEngine");

        RuntimeService runtimeService = processEngine.getRuntimeService();

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "OLEG");
        map.put("surname", "OLEGOV");
        map.put("age", "22");

        runtimeService.startProcessInstanceByKey("myProcess", map);
        return "ok";
    }

    /*public static void main(String[] args) {
        test();
    }*/
}
