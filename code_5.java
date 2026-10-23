/*
Q5. University Login System – Null Pointer Handling

Scenario:
In a university login system, if a user tries to log in with a null username, a
NullPointerException occurs. Handle this gracefully.

Program Structure:
• Class: UniversityLogin
• Method: login(String username)
• Throw or let NullPointerException occur and handle it using try-catch.
*/

import java.util.Scanner;

class UniversityLogin {
    public void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        System.out.println("Login successful! Welcome, " + username);
    }
}

public class code_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversityLogin loginSystem = new UniversityLogin();

        System.out.print("Enter username: ");
        String input = sc.nextLine();

        // If the user enters the string "null" or empty input, treat it as null object
        String username = (input.equalsIgnoreCase("null") || input.trim().isEmpty()) ? null : input;

        try {
            loginSystem.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
