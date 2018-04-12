package storage;

import account.Account;

import java.math.BigDecimal;


public interface DataStorage {
    boolean enrollMoney(Account account, int accountNumber, BigDecimal money);
    boolean writeOfMoney(Account account, int accountNumber, BigDecimal money);
}
