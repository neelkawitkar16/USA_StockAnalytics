package com.eureka.stockAnalysis.inheritance;

import java.math.BigDecimal;

public class CheckingAccount extends Accounts {
    private float cashBack = 2.5F;

    public CheckingAccount(String accountNumber, BigDecimal accountBalance, String accountHolderName) {
        super(accountNumber, accountBalance, accountHolderName);
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Holder Name: " + getAccountHolderName());
    }

    public float getCashBack() {
        return cashBack;
    }

    public void setCashBack(float cashBack) {
        this.cashBack = cashBack;
    }

    public BigDecimal cashBackCalculator() {
        BigDecimal cashBackValue = getLastDebit().multiply(new BigDecimal(cashBack)).divide(new BigDecimal(100));
        setAccountBalance(getAccountBalance().add(cashBackValue));

        return cashBackValue;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "Account Number: " + getAccountNumber() + "\n"+
                "Account Holder Name:" + getAccountHolderName() + "\n" +
                "Account Balance: " + getAccountBalance() + "\n" +
                "cashBack=" + cashBack +
                '}';
    }
}
