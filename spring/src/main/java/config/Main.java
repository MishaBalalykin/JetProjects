package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Autowired
    static A a;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(SpringConfig.class);
        applicationContext.refresh();
        a = applicationContext.getBean(A.class);
        a.callPrint(1);
        a.callPrint(2);
    }
}
