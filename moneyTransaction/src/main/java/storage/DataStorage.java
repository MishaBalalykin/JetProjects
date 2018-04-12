package storage;

import account.Account;

import java.math.BigDecimal;


public interface DataStorage {
    boolean enrollMoney(Account account, BigDecimal money);
    boolean writeOfMoney(Account account,  BigDecimal money);
}
