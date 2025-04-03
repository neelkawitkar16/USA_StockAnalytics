package com.eureka.inheritance;

import java.math.BigDecimal;

public class Circle implements Shape, Color{
    private BigDecimal radius;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public BigDecimal area() {
        BigDecimal area = radius.multiply(radius).multiply(new BigDecimal(3.14));
        return area;
    }

    @Override
    public BigDecimal perimeter() {
        BigDecimal perimeter = radius.multiply(new BigDecimal(6.28));
        return perimeter;
    }

    @Override
    public void paint(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
