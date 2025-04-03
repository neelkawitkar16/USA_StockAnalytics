package com.eureka.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonListManager {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a person");
            System.out.println("2. Search for a person by ID");
            System.out.println("3. Display all persons");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    personList.add(new Person(id, name, age));
                    System.out.println("Person added successfully!");
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int findID = scanner.nextInt();

                    boolean found = false;
                    for (Person person : personList) {
                        if (person.getId() == findID) {
                            System.out.println("Found: " + person.getName() + ", Age: " + person.getAge());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Incorrect " + findID + " provided!!");
                    }
                    break;

                case 3:
                    if (personList.isEmpty()) {
                        System.out.println("List is Empty! Please add a person first!");
                    } else {
                        System.out.println("All persons:");
                        for (Person person : personList) {
                            System.out.println(person);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
