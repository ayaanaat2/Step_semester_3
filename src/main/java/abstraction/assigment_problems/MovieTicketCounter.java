package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 — Movie Ticket Counter.
 * Abstract Ticket makes a plain "ticket" with no seat type impossible to sell.
 * The count and the 20 convenience fee are written once, in the base class;
 * only the seat price changes per subclass.
 *
 * Sample Input:
 * 3
 * REGULAR 3
 * PREMIUM 2
 * RECLINER 1
 *
 * Expected Output:
 * REGULAR: 510.00
 * PREMIUM: 540.00
 * RECLINER: 420.00
 * Total: 1470.00
 */
public class MovieTicketCounter {

    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;

        protected final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract String seat();

        abstract double price();

        final double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) { super(count); }
        String seat() { return "REGULAR"; }
        double price() { return 150; }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) { super(count); }
        String seat() { return "PREMIUM"; }
        double price() { return 250; }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) { super(count); }
        String seat() { return "RECLINER"; }
        double price() { return 400; }
    }

    static Ticket create(String seat, int count) {
        return switch (seat) {
            case "REGULAR" -> new RegularTicket(count);
            case "PREMIUM" -> new PremiumTicket(count);
            case "RECLINER" -> new ReclinerTicket(count);
            default -> throw new IllegalArgumentException("Unknown seat type: " + seat);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            bookings.add(create(seat, count));
        }

        double total = 0;
        for (Ticket t : bookings) {
            double amount = t.amount();
            System.out.printf(Locale.US, "%s: %.2f%n", t.seat(), amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
