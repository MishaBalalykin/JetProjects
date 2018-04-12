package config.account;

import config.exceptions.AccountNumberException;
import config.storage.MapStorage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Account {
    private BigDecimal money;
    private int accountNumber;

    //region Constructors
    public Account(){}

    public Account(int accountNumber, BigDecimal money) {
        this.money = money;
        this.accountNumber = accountNumber;
        try {
            MapStorage.getInstance().setAccountAndAmountOfMoney(this);
        }catch (AccountNumberException e){
            System.err.println("Such accountNumber already exists");
        }
    }


    //endregion

    //region Getters and Setters
    public BigDecimal getMoney() {
        return money.setScale(2,RoundingMode.HALF_UP);
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

    //region Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Objects.equals(money, account.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, accountNumber);
    }

    //endregion
}
