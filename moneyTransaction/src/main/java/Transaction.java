import account.Account;
import exceptions.NotEnouthMoneyException;
import storage.DataStorage;
import storage.MapStorage;

import java.math.BigDecimal;
import java.util.Map;

class Transaction {
    private BigDecimal oldStateAccount;
    private BigDecimal oldStateToAccount;
    private Map<Integer, BigDecimal> accountNumberAndAmountOfMoney =
            MapStorage.getInstance().getAccountNumberAndAmountOfMoney();

    boolean transferMoney(Account account, Account toAccount, BigDecimal money) throws NotEnouthMoneyException {
        initializeStateOfAccounts(account, toAccount);
        if (account.getMoney().compareTo(money) < 0) {
            throw new NotEnouthMoneyException();
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
        mapStorage.writeOfMoney(account, account.getAccountNumber(), money);
        mapStorage.enrollMoney(toAccount, toAccount.getAccountNumber(), money);
    }

    private boolean checkTransactionAndSetOldStateIfTransactionFale(Account account, Account toAccount, BigDecimal money) {
        System.out.println("account = " + account.getMoney());
        System.out.println("oldStateAccount = " + oldStateAccount.subtract(money));
        System.out.println();
        System.out.println("toAccount = " + toAccount.getMoney());
        System.out.println("oldStateToAccount = " + oldStateToAccount.add(money));

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
