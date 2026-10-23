/*
Q4. Student Marks Entry – Input Validation

Scenario:
If a user enters a negative mark or mark greater than 100, throw an exception. Also,
ensure that program always displays a thank you message using finally.

Program Structure:
• Class: StudentMarks
• Method: enterMarks(int marks) — throws exception for invalid range
• Use try-catch-finally.
*/

import java.util.Scanner;

class StudentMarks {
    public void enterMarks(int marks) throws Exception {
        if (marks < 0 || marks > 100) {
            throw new Exception("Marks must be between 0 and 100");
        }
        System.out.println("Marks entered successfully: " + marks);
    }
}

public class code_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentMarks sm = new StudentMarks();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        try {
            sm.enterMarks(marks);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using the system");
        }

        sc.close();
    }
}
