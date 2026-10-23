/*
Q6. Online Shopping – Minimum Purchase Amount Exception

Scenario:
An online shopping system requires a minimum cart value of ₹500 for placing an order.
If below that, throw a user-defined exception.

Program Structure:
• Class: OnlineShopping
• User Defined Exception: MinimumAmountException
• Method: placeOrder(int amount) — throws exception if amount < 500
*/

import java.util.Scanner;

class MinimumAmountException extends Exception {
    public MinimumAmountException(String message) {
        super(message);
    }
}

class OnlineShopping {
    public void placeOrder(int amount) throws MinimumAmountException {
        if (amount < 500) {
            throw new MinimumAmountException("Minimum cart value must be ₹500");
        }
        System.out.println("Order placed successfully! Total amount: ₹" + amount);
    }
}

public class code_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OnlineShopping shop = new OnlineShopping();

        System.out.print("Enter cart amount: ");
        int amount = sc.nextInt();

        try {
            shop.placeOrder(amount);
        } catch (MinimumAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
