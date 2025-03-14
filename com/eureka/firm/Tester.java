package com.eureka.firm;

import java.math.BigDecimal;

public class Tester extends Employee{
    private boolean cucumber;
    private boolean selenium;
    private boolean cyprus;
    private float workex;

    public Tester(String employeeName, int employeeID, String dob, BigDecimal pay, String payFrequency, String designation, String department, String ssn, boolean cucumber, float workex, boolean cyprus, boolean selenium) {
        super(employeeName, employeeID, dob, pay, payFrequency, designation, department, ssn);
        this.cucumber = cucumber;
        this.workex = workex;
        this.cyprus = cyprus;
        this.selenium = selenium;
    }

    public boolean isCucumber() {
        return cucumber;
    }

    public void setCucumber(boolean cucumber) {
        this.cucumber = cucumber;
    }

    public float getWorkex() {
        return workex;
    }

    public void setWorkex(float workex) {
        this.workex = workex;
    }

    public boolean isCyprus() {
        return cyprus;
    }

    public void setCyprus(boolean cyprus) {
        this.cyprus = cyprus;
    }

    public boolean isSelenium() {
        return selenium;
    }

    public void setSelenium(boolean selenium) {
        this.selenium = selenium;
    }
    @Override
    public BigDecimal quaterlyBonus(float rating) {
        BigDecimal bonus;
        if(rating > 2 && rating < 3) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.33));
        } else if (rating > 3 && rating < 4) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.55));
        } else if (rating > 4 && rating < 5) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.75));
        } else {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.1));
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "EmployeeID='" + getEmployeeID() + '\'' +
                "Department='" + getDepartment() + '\'' +
                "cucumber=" + cucumber +
                ", selenium=" + selenium +
                ", cyprus=" + cyprus +
                ", workex=" + workex +
                "}\n";
    }
}
