/*
Q10. Bank Transaction System – Thread Priorities

Scenario:
In a banking application, high-value transactions must be processed with higher priority
than low-value transactions.

Program Structure:
• Class: BankTransaction extends Thread
• Create threads for different transactions and set priorities: MAX_PRIORITY for
  high-value, MIN_PRIORITY for low-value.
*/

import java.util.Scanner;

class BankTransaction extends Thread {
    private String transactionName;
    private double amount;
    private boolean highValue;

    public BankTransaction(String transactionName, double amount, boolean highValue) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.highValue = highValue;
        if (highValue) {
            setPriority(Thread.MAX_PRIORITY);
        } else {
            setPriority(Thread.MIN_PRIORITY);
        }
    }

    @Override
    public void run() {
        if (highValue) {
            System.out.println("High-value transaction processed first");
        } else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class code_10 {
    private static double parseAmount(String input) {
        // Strip out currency symbols such as ₹, Rs, $, spaces if present
        String cleaned = input.replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleaned);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Transaction1: ");
        String t1Str = sc.next();
        double amount1 = parseAmount(t1Str);

        System.out.print("Transaction2: ");
        String t2Str = sc.next();
        double amount2 = parseAmount(t2Str);

        BankTransaction t1;
        BankTransaction t2;

        if (amount1 >= amount2) {
            t1 = new BankTransaction("Transaction1", amount1, true);
            t2 = new BankTransaction("Transaction2", amount2, false);
        } else {
            t1 = new BankTransaction("Transaction1", amount1, false);
            t2 = new BankTransaction("Transaction2", amount2, true);
        }

        BankTransaction highPriority = (t1.getPriority() == Thread.MAX_PRIORITY) ? t1 : t2;
        BankTransaction lowPriority = (highPriority == t1) ? t2 : t1;

        highPriority.start();
        try {
            highPriority.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        lowPriority.start();
        try {
            lowPriority.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sc.close();
    }
}
