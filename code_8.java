/*
Q8. University Printing System – Multiple Threads

Scenario:
A university has multiple printers. Students can send print jobs simultaneously. Each
print job runs on a separate thread.

Program Structure:
• Class: PrinterJob implements Runnable
• Create multiple threads for different students.
• Simulate printing using Thread.sleep().
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PrinterJob implements Runnable {
    private int jobNumber;
    private String studentName;

    public PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Printing job " + jobNumber + " by " + studentName);
        try {
            Thread.sleep(500); // Simulate printing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class code_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int numberOfJobs = sc.nextInt();

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= numberOfJobs; i++) {
            String studentName = "Student " + (char) ('A' + (i - 1));
            Thread t = new Thread(new PrinterJob(i, studentName));
            threads.add(t);
        }

        for (Thread t : threads) {
            t.start();
            try {
                // Ensure print order matches task progression
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        sc.close();
    }
}
