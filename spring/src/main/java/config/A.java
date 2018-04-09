package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class A {
    @Autowired
    @Qualifier("1")
    private B myB;
    @Autowired
    @Qualifier("2")
    private B myB2;
    void callPrint() {
        myB.print();
    }

    void callPrint(int i) {
        if (i == 1) {
            myB.print();
        } else {
            myB2.print();
        }

    }

}
