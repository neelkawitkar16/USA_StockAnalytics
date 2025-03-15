package com.eureka.playground;

import com.eureka.inheritance.Accounts;
import com.eureka.inheritance.CheckingAccount;
import com.eureka.inheritance.SavingsAccount;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GenericsPlayground {
    public static void main(String[] args) {
        ArrayList<Accounts> savingsAccountList = new ArrayList<>();


        savingsAccountList.add(new SavingsAccount("84548", new BigDecimal(5662), "Neel"));
        savingsAccountList.add(new SavingsAccount("847888", new BigDecimal(56343), "Nachi"));
        savingsAccountList.add(new SavingsAccount("878784548", new BigDecimal(562), "Rocky"));

        ArrayList<Accounts> checkingsAccountList = new ArrayList<>();

        checkingsAccountList.add(new CheckingAccount("111", new BigDecimal(5555), "TSLA"));
        checkingsAccountList.add(new CheckingAccount("222", new BigDecimal(12000), "MSFT"));
        checkingsAccountList.add(new CheckingAccount("333", new BigDecimal(100), "AMD"));

        //override the equals method
        if (savingsAccountList.contains(new SavingsAccount("84548", new BigDecimal(5662), "Neel")))
            System.out.println("Yes Savings Account is Present");

        //Add all the checkings accounts to savings account list
        savingsAccountList.addAll(checkingsAccountList);
        System.out.println("The new list is of size: " + savingsAccountList.size());

        // Total balance of all savings and checkings
        System.out.println("The total balance is: " + calculateTotalBalance(savingsAccountList));

        ArrayList<SavingsAccount> savingsAccountList2 = new ArrayList<>();
        savingsAccountList2.add(new SavingsAccount("6666", new BigDecimal(100000), "John"));
        savingsAccountList2.add(new SavingsAccount("2222", new BigDecimal(80000), "Tom"));

        ArrayList<CheckingAccount> checkingsAccountList2 = new ArrayList<>();
        checkingsAccountList2.add(new CheckingAccount("7878", new BigDecimal(45000), "Dick"));
        checkingsAccountList2.add(new CheckingAccount("963369", new BigDecimal(65000), "Hardy"));

        System.out.println("Savings List 2 Total Balance is: " + anotherCalculateTotalBalance(savingsAccountList2));
        System.out.println("Checkings List 2 Total Balance is: " + anotherCalculateTotalBalance(checkingsAccountList));

    }

    public static BigDecimal calculateTotalBalance(ArrayList<Accounts> accountsList) {
        //BigDecimal totalBalance = new BigDecimal(0);
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Accounts x : accountsList) {
            totalBalance = totalBalance.add(x.getAccountBalance());
        }
        return totalBalance;
    }


    //part of generics
    public static BigDecimal anotherCalculateTotalBalance(ArrayList<? extends Accounts> accountsList) {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Accounts x : accountsList) {
            totalBalance = totalBalance.add(x.getAccountBalance());
        }
        return totalBalance;
    }
}
