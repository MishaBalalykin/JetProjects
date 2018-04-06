package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component // инициализ бина происходит javой, не кэшир, configurate кэширует
@ComponentScan(basePackages = "config") //где поискать
class SpringConfig {
    @Bean(name = "1")
    public B getB(){
        B b = new B();
        b.setA(1);
        b.setB(1.1);
        b.setBool(true);
        return b;
    }

}
