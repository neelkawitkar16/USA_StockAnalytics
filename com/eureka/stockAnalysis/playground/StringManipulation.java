package com.eureka.stockAnalysis.playground;

public class StringManipulation {
    public static void main(String[] args) {
        String eureka = "Eureka";
        String info = "InfoTech";
        String concatString = eureka + " " + info;
        System.out.println("Concatenation strings: " + concatString);
        System.out.println("Length of String: " + concatString.length());

        String upperCaseString = concatString.toUpperCase();
        System.out.println(upperCaseString);
        System.out.println(concatString);
        System.out.println("Test Substring: " + upperCaseString.substring(7));
        System.out.println("Character at a position: " + upperCaseString.charAt(7));
        //Check if the String has a particular word/letter
        System.out.println("Test for contains: " + upperCaseString.contains("INFT"));
        System.out.println("Test for ends with: " + upperCaseString.endsWith("TECH"));

        String dummyString = "";
        System.out.println("Test for isBlank: " + dummyString.isBlank());
        System.out.println("Test for isBlank: " + upperCaseString.isBlank());

        String tickers = "AAPL:NVDA:MSFT:AMD";
        String[] splitStrings = tickers.split(":");
        System.out.println("Ticker Symbols: " + splitStrings);
        for (String a: splitStrings) {
            System.out.println(a);
        }
    }
}
