/*
Q9. IoT Sensor Monitoring System

Scenario:
An IoT sensor generates a random number every second.
• If even → Square is calculated by one thread.
• If odd → Cube is calculated by another thread.

Menu:
1. Start Simulation
2. Exit

Program Structure:
• RandomNumberGenerator (Thread) → generates numbers.
• SquareCalculator (Thread) → processes even numbers.
• CubeCalculator (Thread) → processes odd numbers.
• Uses Thread.sleep(), multithreading, and conditional checks.
*/

import java.util.Random;
import java.util.Scanner;

class SquareCalculator extends Thread {
    private int number;

    public SquareCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    private int number;

    public CubeCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

class RandomNumberGenerator extends Thread {
    private int readings;
    private Random random = new Random();

    public RandomNumberGenerator(int readings) {
        this.readings = readings;
    }

    @Override
    public void run() {
        for (int i = 0; i < readings; i++) {
            int number = random.nextInt(10) + 1;
            System.out.println("Generated: " + number);

            Thread calculator;
            if (number % 2 == 0) {
                calculator = new SquareCalculator(number);
            } else {
                calculator = new CubeCalculator(number);
            }

            calculator.start();
            try {
                calculator.join();
                if (i < readings - 1) {
                    Thread.sleep(1000); // 1-second interval between sensor readings
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class code_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Start Simulation");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                RandomNumberGenerator sensor = new RandomNumberGenerator(3);
                sensor.start();
                try {
                    sensor.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else if (choice == 2) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
