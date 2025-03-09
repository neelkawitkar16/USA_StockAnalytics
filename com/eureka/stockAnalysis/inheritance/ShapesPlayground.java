package com.eureka.stockAnalysis.inheritance;

import java.math.BigDecimal;

public class ShapesPlayground {
    public static void main(String[] args) {
        Circle c = new Circle(new BigDecimal(10));
        System.out.println("Area cirle: " + c.area());
        System.out.println("Perimeter cirle: " + c.perimeter());

        Rectangle r = new Rectangle(new BigDecimal(10), new BigDecimal(20));
        System.out.println("\nArea rectangle: " + r.area());
        System.out.println("Perimeter rectangle: " + r.perimeter());

        c.paint("Blue");
        System.out.println("\nCircle State: " + c);

    }
}
