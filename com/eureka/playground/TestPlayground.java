package com.eureka.playground;

import com.eureka.stockAnalysis.vo.Stocks;

import java.util.Arrays;
import java.util.Scanner;

public class TestPlayground {
    public static void main(String[] args) {
        Stocks teslaStock = new Stocks("TSLA", "Tesla Inc.");
        int a = 5;

        passing(teslaStock, a);
        System.out.println("Apple Stock: " + teslaStock + "Integer value:" + a);

        int[] arr = {1,2,3,4,5,6};
        System.out.println(arr);
        System.out.println(arr[4]);
        System.out.println(arr.length);

        String[] names = {"Amogh", "Shone", "Shantanu", "Farhan"};
        System.out.println("printing array without toString gives: " + names);
        System.out.println("printing array with toString gives: " + Arrays.toString(names));

       /* //Java Scanner to accept inputs from user through console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 10: ");
        int userInput = scanner.nextInt();
        System.out.println("The number you entered is: " + userInput);
        //Java Scannar to expect string
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Your name is: " + name);

        //do-while to expect inputs from user bet 1 and 10 in a loop, exit the loop when the condition fails/
        //wrong input from user
        int i = 0;
        do{
            System.out.println("Provide an input between 1 and 10: ");
            i = scanner.nextInt();
        }while(i>0 && i<11);
        System.out.println("Invalid input: " + i);*/



        //Ternary operator
//        String statement = i > 10 ? "The number you entered is greater than 10" : "The number is less than 1";
//        System.out.println(statement);
    }
    public static void passing(Stocks stock, int b) {
        stock.setTickerName("ABC");
        b = 87;
    }
}
