import config.Transaction;
import config.account.Account;
import config.exceptions.NotEnoughMoneyException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class TransactionTest {
    @Test(expected = NotEnoughMoneyException.class)
    public void transferMoney() throws NotEnoughMoneyException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Transaction transaction = context.getBean(Transaction.class);
        Account account = (Account) context.getBean("account");
        Account toAccount = (Account) context.getBean("anotherAccount");

        assertTrue(transaction.transferMoney(account, toAccount, new BigDecimal(120)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(-5)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(0)));
        transaction.transferMoney(account, toAccount, new BigDecimal(1300));
    }
}