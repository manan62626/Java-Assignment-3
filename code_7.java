/*
Q7. Railway Ticket Booking – Synchronization of Threads

Scenario:
In a railway booking system, multiple users are trying to book tickets simultaneously.
Only a limited number of seats are available. Synchronization must ensure that no two
users book the same seat.

Program Structure:
• Class: TicketBooking (Shared Resource)
  - Field: availableSeats
  - Method: bookSeat(int seats) — synchronized
• Thread classes: User1, User2 extending Thread
• Use synchronization to prevent race conditions.
*/

import java.util.Scanner;

class TicketBooking {
    private int availableSeats;

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized boolean bookSeat(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }
}

class User1 extends Thread {
    private TicketBooking booking;
    private int seats;

    public User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    @Override
    public void run() {
        if (booking.bookSeat(seats)) {
            System.out.println("User1 booked " + seats + " seat(s) successfully");
        } else {
            System.out.println("User1 booking failed. Not enough seats");
        }
    }
}

class User2 extends Thread {
    private TicketBooking booking;
    private int seats;

    public User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    @Override
    public void run() {
        if (booking.bookSeat(seats)) {
            System.out.println("User2 booked " + seats + " seat(s) successfully");
        } else {
            System.out.println("User2 booking failed. Not enough seats");
        }
    }
}

public class code_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int user1Seats = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int user2Seats = sc.nextInt();

        TicketBooking booking = new TicketBooking(availableSeats);
        User1 user1 = new User1(booking, user1Seats);
        User2 user2 = new User2(booking, user2Seats);

        user1.start();
        try {
            // Short delay to ensure User1 attempts first
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sc.close();
    }
}
