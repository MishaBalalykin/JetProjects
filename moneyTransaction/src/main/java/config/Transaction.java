package config;

import config.account.Account;
import config.exceptions.NotEnoughMoneyException;
import config.storage.DataStorage;
import config.storage.MapStorage;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Transaction {
    private BigDecimal oldStateAccount;
    private BigDecimal oldStateToAccount;

    public boolean transferMoney(Account account, Account toAccount, BigDecimal money) throws NotEnoughMoneyException {
        if (money.compareTo(new BigDecimal(0)) <=0 ) return false;
        initializeStateOfAccounts(account, toAccount);
        if (account.getMoney().compareTo(money) < 0) {
            throw new NotEnoughMoneyException();
        } else {
            transfer(account, toAccount, money);
            return checkTransactionAndSetOldStateIfTransactionFale(account, toAccount, money);
        }
    }

    private void initializeStateOfAccounts(Account account, Account toAccount) {
        oldStateAccount = account.getMoney();
        oldStateToAccount = toAccount.getMoney();
    }

    private void transfer(Account account, Account toAccount, BigDecimal money) {
        DataStorage mapStorage = MapStorage.getInstance();
        mapStorage.writeOfMoney(account, money);
        mapStorage.enrollMoney(toAccount, money);
    }

    private boolean checkTransactionAndSetOldStateIfTransactionFale(Account account, Account toAccount, BigDecimal money) {
        if (toAccount.getMoney().compareTo(oldStateToAccount.add(money)) == 0 &&
                account.getMoney().compareTo(oldStateAccount.subtract(money)) == 0) {
            return true;
        } else {
            account.setMoney(oldStateAccount);
            toAccount.setMoney(oldStateToAccount);
            return false;
        }
    }
}
