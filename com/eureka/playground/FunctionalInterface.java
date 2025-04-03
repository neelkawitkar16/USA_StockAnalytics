package com.eureka.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();

        listOfStudents.add(new Student(111, "Neel", 81.01, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        System.out.println("The list of students: " + listOfStudents);

        //Lambda expression implementing Predicate : Checking specialization of a Student
        Predicate<Student> mathematicsPredicate = (Student student) -> student.getSpecialization().equals("Mathematics"); //lambda expression

        List<Student> mathematicsStudents = new ArrayList<>(); //initialize empty mathematicsStudents list to store specialization mathematics students
        for (Student student : listOfStudents) {
            if(mathematicsPredicate.test(student)) {
                mathematicsStudents.add(student);
            }
        }
        System.out.println("Students with mathematics as specialization: " + mathematicsStudents);

        //Using streams
        List<Student> mathematicsStudent = listOfStudents.stream()
                .filter(mathematicsPredicate)
                .collect(Collectors.toList());
        System.out.println("\nUsing streams to check the students specialization is Mathematics: " + mathematicsStudent);


        //Lambda expression implementing Consumer : Displaying all students with their percentage
        Consumer<Student> percentageConsumer = (Student student) -> {
            System.out.println(student.getName() + " : " + student.getPercentage());
        };
        for(Student student : listOfStudents) {
            percentageConsumer.accept(student);
        }

        //Using streams
        listOfStudents.stream()
                .forEach((Student stu) -> System.out.println(stu.getName() + " " + stu.getPercentage()));
                //.forEach( stu -> System.out.println(stu.getName() + " " + stu.getPercentage()));    alternative 1
                //.forEach(percentageConsumer);    alternative 2


        //Lambda expression implementing Function : Extracting only the names of all students
        Function<Student, String> nameFunction = (Student student) -> student.getName(); //Input is student object and outputs its name as a String

        List<String> studentNames = new ArrayList<String>();
        for (Student student : listOfStudents)
        {
            studentNames.add(nameFunction.apply(student));
        }
        System.out.println("Using Function<T,R> which applies to object to get student names: " + studentNames);

        //Using streams
        List<String> studentNamesList = listOfStudents.stream()
                .map((Student stu) -> stu.getName())
                //.map( stu -> stu.getName())                       alternative
                .collect(Collectors.toList());
        System.out.println("\nUsing streams: " + studentNamesList);

        //Lambda expression implementing Supplier : Creating a new Student
        Supplier<Student> studentSupplier = () -> new Student(111111, "New Student", 92.9, "Java 8");   //Supplier<T>, where T is the type of object it supplies (Student in this case)
        listOfStudents.add(studentSupplier.get());  //get method executes the lambda expression, which creates and returns a new Student object
        System.out.println("\nUsing supplier to add a new student: " + listOfStudents);

    }
}
