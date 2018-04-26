package misha;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.springframework.stereotype.Service;

@Service
public class ConsolWriter {
    Initialaizer initialaizer = new Initialaizer();

    public void printMessageAZero(ActivityExecution execution) {
        System.out.println("zero " + initialaizer.a);
    }

    public void printMessageA(ActivityExecution execution) {
        System.out.println("not zero " + initialaizer.a);
    }
}
