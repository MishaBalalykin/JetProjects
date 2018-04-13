import config.SpringConfig;
import config.Transaction;
import config.account.Account;
import config.exceptions.NotEnoughMoneyException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {
    @Autowired
    static Transaction transaction;
    @Autowired
    static private Account account;
    @Autowired
    static private Account toAccount;

    @Test(expected = NotEnoughMoneyException.class)
    public void transferMoney() throws NotEnoughMoneyException {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        applicationContext.register(SpringConfig.class);
        applicationContext.refresh();
        transaction = applicationContext.getBean(Transaction.class);
        account = applicationContext.getBean("first acc", Account.class);
        toAccount = applicationContext.getBean("second acc", Account.class);

        assertTrue(transaction.transferMoney(account, toAccount, new BigDecimal(1200)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(-5)));
        assertFalse(transaction.transferMoney(account, toAccount, new BigDecimal(0)));
        transaction.transferMoney(account, toAccount, new BigDecimal(1300));
    }
}