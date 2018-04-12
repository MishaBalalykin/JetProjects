package account;

import exceptions.AccountNumberException;
import storage.MapStorage;

import java.math.BigDecimal;

public class Account {
    private BigDecimal money;
    private int accountNumber;

    //region Constructors

    public Account(int accountNumber, BigDecimal money) {
        this.money = money;
        this.accountNumber = accountNumber;
        try {
            MapStorage.getInstance().setAccountNumberAndAmountOfMoney(accountNumber, money);
        }catch (AccountNumberException e){
            System.err.println("Such accountNumber already exists");
        }
    }


    //endregion

    //region Getters and Setters
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    //endregion
}
