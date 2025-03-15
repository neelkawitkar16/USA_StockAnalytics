package com.eureka.firm;

import java.math.BigDecimal;

public class FirmOperations {
    public BigDecimal totalAnnualPay(Employee[] company) {
        BigDecimal totalPay = new BigDecimal(0);
        for (Employee emp: company) {
            totalPay= totalPay.add(emp.annualPay());
        }
        return totalPay;
    }

    public void changeDepartmentName(Employee[] company, String fromDept, String toDept) {
        for (Employee emp: company) {
            if(emp.getDepartment().equalsIgnoreCase(fromDept)) {
                emp.setDepartment(toDept);
            }
        }
    }

    public int checkDesignation(Employee[] company, String deg) {
        int count = 0;
        for (Employee emp: company) {
            if (emp.getDesignation().equalsIgnoreCase(deg)) {
                count++;
            }
        }
        return count;
    }

    public BigDecimal bonusImpact(Employee[] firm, float rating) {
        BigDecimal bonus = new BigDecimal(0);
        for (Employee emp : firm) {
            bonus = bonus.add(emp.quaterlyBonus(rating));
            System.out.println("Bonus of: " + emp.getEmployeeID() + " is: " + emp.quaterlyBonus(rating));
        }
        return bonus;
    }

    public static void myName() {
        System.out.println("This is a static method and my name is Neel");
    }
}
