package config.storage;

import config.account.Account;
import config.exceptions.AccountNumberException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class MapStorage implements DataStorage {
    private static MapStorage instance;
    private Map<Integer, Account> accountAndAmountOfMoney;

    //region Singleton
    private MapStorage() {
        accountAndAmountOfMoney = new HashMap<>();
    }

    public static MapStorage getInstance() {
        if (instance == null) {
            instance = new MapStorage();
        }
        return instance;
    }

    //endregion

    @Override
    public boolean writeOfMoney(Account account, BigDecimal money) {
        account.setMoney(account.getMoney().subtract(money));
        accountAndAmountOfMoney.put(account.getAccountNumber(), account);
        return true;
    }

    @Override
    public boolean enrollMoney(Account account, BigDecimal money) {
        account.setMoney(account.getMoney().add(money).setScale(2, RoundingMode.HALF_UP));
        accountAndAmountOfMoney.put(account.getAccountNumber(), account);
        return true;
    }

    //region Getters andSetters

    public Map<Integer, Account> getAccountAndAmountOfMoney() {
        return accountAndAmountOfMoney;
    }

    public void setAccountAndAmountOfMoney(Account account) throws AccountNumberException {
        if (accountAndAmountOfMoney.containsKey(account.getAccountNumber())) {
            throw new AccountNumberException();
        } else accountAndAmountOfMoney.put(account.getAccountNumber(), account);
    }

    //endregion
}
