/*
Q2. Student Age Validation – User Defined Exception

Scenario:
While registering students, the age must be above 17. If not, throw a user-defined
exception.

Program Structure:
• Class: Student
• User Defined Exception: InvalidAgeException
• Method: registerStudent(int age) — throws InvalidAgeException if age < 17
• Handle using try-catch.
*/

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Student {
    public void registerStudent(int age) throws InvalidAgeException {
        if (age <= 17) {
            throw new InvalidAgeException("Age must be above 17 for registration");
        }
        System.out.println("Student registered successfully");
    }
}

public class code_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student student = new Student();

        try {
            student.registerStudent(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
