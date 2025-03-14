package com.eureka.firm;

import com.eureka.inheritance.Test;

import java.math.BigDecimal;

public class EmployeePlayground {
    public static void main(String[] args) {
        /*Employee e1 = new Employee("Neel", 11397, "03/16/1997",
                                new BigDecimal(110000), "B", "Software Engineer",
                            "IT", "946-15-5688");

        System.out.println("E1 pay frequency is: " + e1.getPayFrequency());
        System.out.println("Annual pay for e1 is : " + e1.annualPay());*/

        Manager m1 = new Manager("Steve Jobs", 435234, "02/13/1963",
                new BigDecimal(500000), "W", "CEO", "IT", "549-13-6899",
                "9028", "Apple", 45000);

        System.out.println("Manager M1 annual pay: " + m1.annualPay());

        Tester t1 = new Tester("Diwakar", 54564, "09/16/1978",
                new BigDecimal(5000), "M", "Software Tester", "Testing", "549-13-6345",
                true, 9.5f, false, false);

        System.out.println("Tester t1 annual pay: " + t1.annualPay());
    }
}