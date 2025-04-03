package com.eureka.firm;

import java.math.BigDecimal;

public class Developer extends Employee{
    private String techStack;
    private float workex;
    private String lastClient;

    public Developer(String employeeName, int employeeID, String dob, BigDecimal pay, String payFrequency, String designation, String department, String ssn, String techStack, String lastClient, float workex) {
        super(employeeName, employeeID, dob, pay, payFrequency, designation, department, ssn);
        this.techStack = techStack;
        this.lastClient = lastClient;
        this.workex = workex;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getLastClient() {
        return lastClient;
    }

    public void setLastClient(String lastClient) {
        this.lastClient = lastClient;
    }

    public float getWorkex() {
        return workex;
    }

    public void setWorkex(float workex) {
        this.workex = workex;
    }


    @Override
    public BigDecimal quaterlyBonus(float rating) {
        BigDecimal bonus;
        if(rating > 2 && rating < 3) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.50));
        } else if (rating > 3 && rating < 4) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.70));
        } else if (rating > 4 && rating < 5) {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.90));
        } else {
            bonus = annualPay().divide(new BigDecimal(4)).multiply(new BigDecimal(0.15));
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "EmployeeID='" + getEmployeeID() + '\'' +
                "Department='" + getDepartment() + '\'' +
                "techStack='" + techStack + '\'' +
                ", workex=" + workex +
                ", lastClient='" + lastClient + '\'' +
                "}\n";
    }
}
