package com.eureka.stockAnalysis.inheritance;

import java.math.BigDecimal;

public class Rectangle implements Shape {
    BigDecimal length;
    BigDecimal breadth;

    public Rectangle(BigDecimal length, BigDecimal breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getBreadth() {
        return breadth;
    }

    public void setBreadth(BigDecimal breadth) {
        this.breadth = breadth;
    }

    @Override
    public BigDecimal area() {
        return length.multiply(breadth);
    }

    @Override
    public BigDecimal perimeter() {
        return length.add(breadth).multiply(new BigDecimal(2));
    }
}
