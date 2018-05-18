package com.jet.edu.impl;

import com.jet.edu.api.Writer;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BpmnWriter implements JavaDelegate {
    private ApplicationContext context;
    private Writer writer;
    public BpmnWriter() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        writer = context.getBean("oracleWriter", OracleWriter.class);
    }
//    writer writer = new OracleWriter();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        writer.write(delegateExecution.getVariables());
    }
}
