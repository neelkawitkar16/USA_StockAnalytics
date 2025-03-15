package com.eureka.firm;

import java.math.BigDecimal;
import java.util.Arrays;

public class FirmHead {
    static {
        System.out.println("Test for static code block");
        FirmOperations.myName();
    }

    public static void main(String[] args) {
        Employee[] firm = createFirm();
        FirmOperations firmops = new FirmOperations();

        System.out.println("Total pay of the firm is: " + firmops.totalAnnualPay(firm));

        firmops.changeDepartmentName(firm, "Delivery", "IT");

        System.out.println("All employees" + Arrays.toString(firm));

        System.out.println("Number of developers: " + firmops.checkDesignation(firm, "Dev"));

        //Test bonus impact
        BigDecimal totalBonus = firmops.bonusImpact(firm, 3F);
        System.out.println("Total bonus is: " + totalBonus);

        FirmOperations.myName();

    }

    public static Employee[] createFirm() {
        Employee[] firm = new Employee[6];
        // 3 dev, 2 testers, 1 manager
        Developer dev1 = new Developer("Rocky", 95656, "03/14/1994", new BigDecimal(6000),
                "B", "dev", "Delivery", "986-85-9833", "Java Developer",
                "TESLA", 4);
        firm[0] = dev1;

        Developer dev2 = new Developer("Rani", 67656, "03/12/1984", new BigDecimal(6050),
                "B", "dev", "Delivery", "986-85-9553", "Java Developer",
                "APPLE", 4);
        firm[1] = dev2;

        System.out.println("Default equals method: " + dev1.equals(dev2));
        // Check for equals method where you can specifically check for two objects contents

        Developer dev3 = new Developer("Superman", 87656, "03/12/1974", new BigDecimal(7000),
                "B", "dev", "Delivery", "896-85-9553", "Sr. Java Developer",
                "GOOGLE", 8);
        firm[2] = dev3;

        Tester t1 = new Tester("John", 54564, "09/16/1978",
                new BigDecimal(5400), "M", "Software Tester", "Delivery", "549-13-6345",
                true, 6.6f, false, false);
        firm[3] = t1;

        Tester t2 = new Tester("Smith", 89624, "09/16/1999",
                new BigDecimal(1000), "M", "Jr. Software Tester", "Delivery", "149-78-6345",
                false, 2, true, false);
        firm[4] = t2;

        Manager m1 = new Manager("Mark Zuckerberg", 11134, "10/26/1988",
                new BigDecimal(500000), "W", "CEO", "Delivery", "111-13-6899",
                "3428", "FB", 5);
        firm[5] = m1;

        return  firm;
    }
}
