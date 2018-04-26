package misha;

import org.activiti.engine.RuntimeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RuntimeService runtimeService = (RuntimeService) applicationContext.
                getBean("runtimeService");
        runtimeService.startProcessInstanceByKey("myFirstActivity");
    }
}
