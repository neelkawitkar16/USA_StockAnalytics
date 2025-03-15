package com.eureka.playground;

import com.eureka.inheritance.CheckingAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListPlayground {
    public static void main(String[] args) {
        //ArrayList does not take primitive datatypes
        //Creating an ArrayList
        ArrayList<String> tickerSymbol = new ArrayList<>();
        tickerSymbol.add("AAPL");
        tickerSymbol.add("TSLA");
        tickerSymbol.add("NVDA");
        tickerSymbol.add("AMD");

        System.out.println("ArrayList Ticker symbols are: " + tickerSymbol);
        System.out.println("The size of ticker symbols ArrayList is: " + tickerSymbol.size());

        //remove from ArrayList by position/index
        String remove = tickerSymbol.remove(1);
        System.out.println("Remove ArrayList element at position 2: " + remove);
        System.out.println("The size of ticker symbols ArrayList after removal is: " + tickerSymbol.size());

        //contains()
        if (tickerSymbol.contains("AAPL"))
            System.out.println("Yes! AAPL is part of the tickerSymbol ArrayList");

        //get()
        String position = tickerSymbol.get(2);
        System.out.println(position);

        if(tickerSymbol.isEmpty()) {
            System.out.println("Ticker symbols arraylist is empty");
        }

        //add few more to ticker symbols
        tickerSymbol.add("MSFT");
        tickerSymbol.add("AMD");
        tickerSymbol.add("TSLA");

        // ArrayList preserves the order
        for (int i = 0; i < tickerSymbol.size(); i++) {
            String s = tickerSymbol.get(i);
            System.out.println("For loop elements of ticker symbol arraylist: " + s);
        }

        for (String x : tickerSymbol) {
            System.out.println("For each loop of ticker symbol arraylist: " + x);
        }

        // sort() the Arraylist elements of the tickerSymbol
         Collections.sort(tickerSymbol);
        System.out.println(tickerSymbol);

        // without declaring the type of the ArrayList. It can take heterogeneous values. Not recommended
        ArrayList junkList = new ArrayList();
        junkList.add("JunkValue");
        junkList.add(new CheckingAccount("ABC", new BigDecimal(10), "XYZ"));
        junkList.add(new BigDecimal(15));

        System.out.println("Print the junkList = " + junkList);

        ArrayList<String> dummyList = new ArrayList<>();

        // isEmpty
        if(dummyList.isEmpty()) {
            System.out.println("Dummy list is EMPTY!!");
        }

    }
}
