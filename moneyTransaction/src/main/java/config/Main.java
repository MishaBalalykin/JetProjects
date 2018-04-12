package config;

import config.account.Account;
import config.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        Account account = new Account(1, new BigDecimal(1200.15));
        Account toAccount = new Account(2, new BigDecimal(999.9));

        System.out.println("Денег на первом аккаунте: "+account.getMoney());
        System.out.println("Денег на втором аккаунте: "+toAccount.getMoney());
        System.out.println("Транзакция");

        try {
            transaction.transferMoney(account, toAccount, new BigDecimal(-5));
        } catch (NotEnoughMoneyException e) {
            System.out.println("Недостаточно средств для перевода");
        }

        System.out.println("Денег на первом аккаунте: "+account.getMoney());
        System.out.println("Денег на втором аккаунте: "+toAccount.getMoney());
    }
}
