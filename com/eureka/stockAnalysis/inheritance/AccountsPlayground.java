package com.eureka.stockAnalysis.inheritance;

import java.math.BigDecimal;

public class AccountsPlayground {
    public static void main(String[] args) {
        CheckingAccount checkings1 = new CheckingAccount("123456", new BigDecimal(5784), "Neel");
        System.out.println("First Checking Account: " + checkings1);

        BigDecimal accountBalance = checkings1.creditAccount(new BigDecimal(56));
        System.out.println("Updated Account Balance is: " + accountBalance);

        checkings1.debitAccount(new BigDecimal(89));
        checkings1.cashBackCalculator();
        System.out.println("New Account State: " + checkings1);

        checkings1.cashBackCalculator();

        SavingsAccount savings1 = new SavingsAccount("123456", new BigDecimal(1500), "Kawitkar");
        savings1.interestCalculator();
        System.out.println("\n Savings Accounts State: " + savings1);
    }
}
