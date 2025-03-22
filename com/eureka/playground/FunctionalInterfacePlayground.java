package com.eureka.playground;

import com.eureka.stockAnalysis.vo.StockFundamentals;
import com.eureka.stockAnalysis.vo.StockFundamentalsVO;

import java.math.BigDecimal;
import java.util.function.*;

public class FunctionalInterfacePlayground {
    public static void main(String[] args) {
        //Example of UnaryOperator
        calculateSquare(10);
        UnaryOperator<Integer> calculateSquareUR = num -> num*num;   // OR: (num) -> num*num
        System.out.println("Calculate Square using a method: " + calculateSquare(10));
        System.out.println("Calculate Square using Unary Operator: " + calculateSquareUR.apply(10));

        //Example of Binary Operator
        BinaryOperator<Integer> calculateProductBR = (num1, num2) -> num1*num2;
        System.out.println("Calculate the product of two numbers using Binary operator: " + calculateProductBR.apply(2, 3));


        System.out.println("Concatenate Strings using a method: " + concatStrings("Neel", "Kawitkar"));
        //Example of Binary Operator of type <String>
        BinaryOperator<String> concatStringBR = (str1, str2) -> { //if you want to write multiple line use {}
            System.out.println("String 1: " + str1);
            System.out.println("String 2: " + str2);
            return  str1.concat(" ").concat(str2);   // return is necessary
        };//Lambda Function
        System.out.println("Concatenate Strings using Binary Operator: " + concatStringBR.apply("Neel", "Kawitkar"));

        //Example of a Consumer
        printSomeValue("LOL and HAHA");
        //Lambda Function
        Consumer<String> printSomethingCN = (x) -> System.out.println("Print something: " + x); // accepts input and return nothing
        printSomethingCN.accept("LOL, HEHE, HAHA");

        //Consumer using Method Referencing
        Consumer<String> printValueCN =  System.out::println;
        printValueCN.accept("Test Method Referencing");

        //Custom method Referencing
        Consumer<String> printTestCN = FunctionalInterfacePlayground::printSomeValue;
        printTestCN.accept("Something in Consumer Test");

        // Stock analysis
        StockFundamentalsVO nvdiaStock = new StockFundamentalsVO("NVDA", 12, 34,
                                                                            new BigDecimal(565444), 45.2F);

        Consumer<StockFundamentalsVO> printSFO = System.out::println;
        printSFO.accept(nvdiaStock);

        //Example of Supplier using Lamda Function
        Supplier<Double> randomNumberSP = () -> Math.random();
        System.out.println("A random number 1: " + randomNumberSP.get());

        //Example of Supplier using Method Reference
        Supplier<Double> randomNumberMR_SP = Math::random;
        System.out.println("A random number 2: " + randomNumberMR_SP.get());

        //Example of Predicate using lamda function (returns boolean)
        Predicate<String> emptyStringPD = x -> {
            System.out.println("The String is: " + x);
            return x.isEmpty();
        };
        System.out.println("Is the String Empty: " + emptyStringPD.test("Eureka"));
        System.out.println("Is the String Empty: "+emptyStringTest("Eureka"));

        //Example of Bipredicate
        BiPredicate<String, Integer> stringLengthTestBP = (s, i) -> s.length() == i;
        System.out.println("Is Kawitkar 10 charactered: " + stringLengthTestBP.test("Kawitkar", 10));

        BiConsumer<String, String> test = (str1, str2) -> {
            if (str1.length() == str2.length())
                System.out.println("Same length");
        };
        test.accept("Eureka", "Infotc");

        //Example of function using Lambda Expression -> IMP
        Function<String, Integer> stringLengthFN = s -> s.length(); //can customize
        System.out.println("String length using Method referencing: " + stringLengthFN.apply("Eureka"));
        //Example of function using Lambda Expression -> IMP
        Function<String, Integer> stringLengthFN_MR = String::length; //can't customize
        System.out.println("String length using Method referencing: " + stringLengthFN_MR.apply("Eureka"));

        //Example of BiFunction
        BiFunction<String, String, Integer> multiplyStringLength = (str1, str2) -> str1.length()*str2.length();
        System.out.println("Product of two Strings Str1 and Str2 using BiFunction is: " + multiplyStringLength.apply("Neel", "Kawitkar"));

        //Chaining function
        Function<String, Integer> chainedFunction = stringLengthFN.andThen(n -> n*10);
        System.out.println("String length using chained function: " + chainedFunction.apply("Neel"));
    }

    private static boolean emptyStringTest(String x){
        System.out.println("The String is: "+x);
        return x.isEmpty();
    }

    private static Integer productofStringLengths(String s1, String s2) {
        return s1.length()*s2.length();
    }

    private static Integer calculateSquare(Integer i) {
        return i*i;
    }

    private  static String concatStrings(String s1, String s2) {
        return s1.concat(s2);
    }

    private static void printSomeValue(String s) {
        System.out.println("Print something: " + s);
    }
}
