package config;

import config.account.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component // инициализ бина происходит javой, не кэшир, configurate кэширует
@ComponentScan(basePackages = "config") //где поискать
public class SpringConfig {
    @Bean(name = "first acc")
    public Account getAccount(){
        Account account = new Account();
        account.setAccountNumber(1);
        account.setMoney(new BigDecimal(1200.15));
        return account;
    }
    @Bean(name = "second acc")
    public Account getAnotherAccount(){
        Account account = new Account();
        account.setAccountNumber(2);
        account.setMoney(new BigDecimal(999.9));
        return account;
    }
}
