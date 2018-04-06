package config;

import org.springframework.stereotype.Component;

@Component(value = "2")
class B {
    private Integer a;
    private Double b;
    private boolean bool;

    void setA(Integer a) {
        this.a = a;
    }

    void setB(Double b) {
        this.b = b;
    }

    void setBool(boolean bool) {
        this.bool = bool;
    }

    void print(){
        System.out.println("first spring app");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("bool = " + bool);
    }
}
