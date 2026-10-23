/*
Q3. Array Division – Handling Arithmetic and Array Index Exception (Multiple Catch)

Scenario:
A program takes two numbers and an array index. It divides array[index] by the number.
You need to handle both ArithmeticException (if divisor = 0) and
ArrayIndexOutOfBoundsException (if index invalid).

Program Structure:
• Class: ArrayDivision
• Use multiple catch blocks.
*/

import java.util.Scanner;

class ArrayDivision {
    private int[] array = {10, 20, 30, 40};

    public int divide(int index, int divisor) {
        return array[index] / divisor;
    }
}

public class code_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDivision ad = new ArrayDivision();

        System.out.println("Array: [10, 20, 30, 40]");
        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            int result = ad.divide(index, divisor);
            System.out.println("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("Exception: Division by zero not allowed");
        }

        sc.close();
    }
}
