package com.eureka.stockAnalysis.inheritance;

import java.math.BigDecimal;

public abstract class Accounts {
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal accountBalance;
    private BigDecimal lastDebit;

    public Accounts(String accountNumber, BigDecimal accountBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolderName = accountHolderName;
    }

    public BigDecimal getLastDebit() {
        return lastDebit;
    }

    public void setLastDebit(BigDecimal lastDebit) {
        this.lastDebit = lastDebit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal creditAccount(BigDecimal credit) {
        accountBalance = accountBalance.add(credit);
        return accountBalance;
    }

    public void debitAccount(BigDecimal debit) {
        accountBalance = accountBalance.subtract(debit);
        lastDebit = debit;
        System.out.println("Updated Account Balance is: " + accountBalance);
    }

    public abstract void printAccountDetails();
}
