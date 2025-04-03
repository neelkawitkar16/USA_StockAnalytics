package com.eureka.inheritance;

import java.math.BigDecimal;

public class SavingsAccount extends Accounts{
    private float interestRate = 2.0F;

    public SavingsAccount(String accountNumber, BigDecimal accountBalance, String accountHolderName) {
        super(accountNumber, accountBalance, accountHolderName);
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber());
    }

    public float getInterRate() {
        return interestRate;
    }

    public void setInterRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal interestCalculator() {
       BigDecimal intermediate = getAccountBalance().multiply(new BigDecimal(interestRate));
       BigDecimal interestValue = intermediate.divide(new BigDecimal(100));
       setAccountBalance(getAccountBalance().add(interestValue));

       return interestValue;
    }

    @Override
    public String toString() {
        return "Account Number: " + getAccountNumber() + "\n"+
                "Account Holder Name:" + getAccountHolderName() + "\n" +
                "Account Balance: " + getAccountBalance() + "\n" +
                "interestRate=" + interestRate +
                '}';
    }
}