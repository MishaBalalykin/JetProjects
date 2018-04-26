package misha;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class Initialaizer implements JavaDelegate {
    public int a = 1;
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("a", a);
    }
}
