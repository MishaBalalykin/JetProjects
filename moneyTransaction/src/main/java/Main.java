import account.Account;
import exceptions.NotEnouthMoneyException;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        Account account = new Account(1, new BigDecimal(1200.15));
        Account toAccount = new Account(2, new BigDecimal(999.9));

        System.out.println(account.getMoney());
        System.out.println(toAccount.getMoney());
        System.out.println();

        try {
            transaction.transferMoney(account, toAccount, new BigDecimal(1300));
        } catch (NotEnouthMoneyException e) {
            System.out.println("Недостаточно средств для перевода");
        }

        System.out.println();
        System.out.println(account.getMoney());
        System.out.println(toAccount.getMoney());
    }
}
