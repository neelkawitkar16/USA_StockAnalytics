package com.eureka.firm;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Employee {
    private String employeeName;
    private int employeeID;
    private String dob;
    private BigDecimal pay;
    private String payFrequency;
    private String designation;
    private String department;
    private String ssn;
    private static int firmCounter = 0;
    private int testFirmCounter = 0;
    private static String firmName;

    public Employee(String employeeName, int employeeID, String dob, BigDecimal pay, String payFrequency, String designation, String department, String ssn) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.dob = dob;
        this.pay = pay;
        this.payFrequency = payFrequency;
        this.designation = designation;
        this.department = department;
        this.ssn = ssn;
        firmCounter++;
        testFirmCounter++;
    }

    @Override
    // checks only for specific parameter of the objects
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return employeeID == employee.employeeID && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, employeeID);
    }

    public static int getFirmCounter() {
        return firmCounter;
    }

    public static void setFirmCounter(int firmCounter) {
        Employee.firmCounter = firmCounter;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //one way to write if else
    public BigDecimal annualPay() {
        BigDecimal annualPay;
        /*if(payFrequency.equalsIgnoreCase("M")) {
            annualPay = pay.multiply(new BigDecimal(12));
        } else if (payFrequency.equalsIgnoreCase("B")) {
            annualPay = pay.multiply(new BigDecimal(26));
        } else {
            annualPay = pay.multiply(new BigDecimal(52));
        }*/

        switch (payFrequency.toUpperCase()) {
            case "M":
                annualPay = pay.multiply(new BigDecimal(12));
                break;
            case "B":
                annualPay = pay.multiply(new BigDecimal(26));
                break;
            default:
                annualPay = pay.multiply(new BigDecimal(52));
        }
        return annualPay;
    }

    public void appraisal() {
        /*if(designation.equalsIgnoreCase("Manager")){
            pay = pay.multiply(new BigDecimal(1.12));
        } else if (designation.equalsIgnoreCase("Tester")) {
            pay = pay.multiply(new BigDecimal(1.25));
        } else {
            pay = pay.multiply(new BigDecimal(1.35));
        }*/

        switch (designation.toUpperCase()) {
            case "Manager":
                pay = pay.multiply(new BigDecimal(1.12));

            case "Tester":
                pay = pay.multiply(new BigDecimal(1.25));

            default:
                pay = pay.multiply(new BigDecimal(2));
        }
    }

    public abstract BigDecimal quaterlyBonus(float rating);

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeID=" + employeeID +
                ", pay=" + pay +
                ", payFrequency='" + payFrequency + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
