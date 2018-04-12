package storage;

import account.Account;
import exceptions.AccountNumberException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MapStorage implements DataStorage {
    private static MapStorage instance;
    private Map<Integer, BigDecimal> accountNumberAndAmountOfMoney;

    private MapStorage() {
        accountNumberAndAmountOfMoney = new HashMap<>();
    }

    public static MapStorage getInstance() {
        if (instance == null) {
            instance = new MapStorage();
        }
        return instance;
    }

    @Override
    public boolean enrollMoney(Account account, int accountNumber, BigDecimal money) {
        //System.out.println("accountNumberAndAmountOfMoney = " + accountNumberAndAmountOfMoney.get(accountNumber));
        accountNumberAndAmountOfMoney.put(accountNumber, accountNumberAndAmountOfMoney.get(accountNumber).add(money));
        //System.out.println("accountNumberAndAmountOfMoney = " + accountNumberAndAmountOfMoney.get(accountNumber));
        account.setMoney(account.getMoney().add(money));
        return true;
    }

    @Override
    public boolean writeOfMoney(Account account, int accountNumber, BigDecimal money) {
        //System.out.println("WRITEOFaccountNumberAndAmountOfMoney = " + accountNumberAndAmountOfMoney.get(accountNumber));
        accountNumberAndAmountOfMoney.put(accountNumber, accountNumberAndAmountOfMoney.get(accountNumber).subtract(money));
        account.setMoney(account.getMoney().subtract(money));
        //System.out.println("WRITEOFaccountNumberAndAmountOfMoney = " + accountNumberAndAmountOfMoney.get(accountNumber));
        return true;
    }

    //region Getters andSetters
    public Map<Integer, BigDecimal> getAccountNumberAndAmountOfMoney() {
        return accountNumberAndAmountOfMoney;
    }

    public void setAccountNumberAndAmountOfMoney(int accountNumber, BigDecimal money) throws AccountNumberException {
        if (this.accountNumberAndAmountOfMoney.containsKey(accountNumber)){
            throw new AccountNumberException();
        }
        this.accountNumberAndAmountOfMoney.put(accountNumber, money);
    }
//endregion
}
