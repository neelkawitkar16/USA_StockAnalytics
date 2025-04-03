package com.eureka.firm;

import java.math.BigDecimal;

public class Manager extends Employee {
    private String ProjectID;
    private int noOfSub;
    private String history;

    public Manager(String employeeName, int employeeID, String dob, BigDecimal pay, String payFrequency, String designation, String department, String ssn, String projectID, String history, int noOfSub) {
        super(employeeName, employeeID, dob, pay, payFrequency, designation, department, ssn);
        ProjectID = projectID;
        this.history = history;
        this.noOfSub = noOfSub;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getNoOfSub() {
        return noOfSub;
    }

    public void setNoOfSub(int noOfSub) {
        this.noOfSub = noOfSub;
    }

    @Override
    public BigDecimal quaterlyBonus(float rating) {
        BigDecimal bonus;
        if(rating > 2 && rating < 3) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.20));
        } else if (rating > 3 && rating < 4) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.30));
        } else if (rating > 4 && rating < 5) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.50));
        } else {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.10));
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ProjectID='" + ProjectID + '\'' +
                "EmployeeID='" + getEmployeeID() + '\'' +
                "Department='" + getDepartment() + '\'' +
                ", noOfSub=" + noOfSub +
                ", history='" + history + '\'' +
                "}\n";
    }
}
