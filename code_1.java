/*
Q1. ATM Withdrawal System – Handling Insufficient Balance

Scenario:
In a banking system, when a user tries to withdraw more money than their account
balance, the system should throw an exception and display an appropriate message.

Program Structure:
• Class: ATM
  - Field: balance
  - Method: withdraw(double amount) — throws exception if amount > balance
• Exception: Use throw and try-catch
• Use finally block to display "Transaction Completed".
*/

import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class code_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        ATM atm = new ATM(balance);

        try {
            atm.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Transaction Completed");
        }

        sc.close();
    }
}
