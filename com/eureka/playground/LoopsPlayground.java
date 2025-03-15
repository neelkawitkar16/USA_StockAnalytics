package com.eureka.playground;

public class LoopsPlayground {
    public static void main(String[] args) {
        int k = 0;
        int j = 3;

        while (k < 5) {
            System.out.println("Value of k: " + k);
            j++;
            if(j == 5) {
                break;
            }
        }

        do{
            System.out.println("Do while k: " + k);
            k++;
        }while(k < 5);

        //Ternary operator
        System.out.println("k value: " + k);
        int a = k == 4? k++ : 98;
        System.out.println("Value of a: " + a);
    }
}
