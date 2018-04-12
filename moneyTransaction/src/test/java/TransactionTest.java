import account.Account;
import exceptions.NotEnoughMoneyException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {
    /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    @Test(expected = NotEnoughMoneyException.class)
    public void transferMoney() throws NotEnoughMoneyException {

    }*/

    private Transaction transaction = new Transaction();
    private Account account = new Account(1, new BigDecimal(1200.15));
    private Account toAccount = new Account(2, new BigDecimal(999.9));

    @Test(expected = NotEnoughMoneyException.class)
    public void transferMoney() throws NotEnoughMoneyException {
        assertTrue(transaction.transferMoney(account, toAccount, new BigDecimal(1200)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(-5)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(0)));
        transaction.transferMoney(account, toAccount, new BigDecimal(1300));
    }
}