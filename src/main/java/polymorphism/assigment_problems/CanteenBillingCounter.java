package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 — The Canteen Billing Counter.
 *   Student: 10% discount, Staff: 5% discount, Guest: full amount + 10 service charge.
 *
 * Sample Input:
 * 3
 * STUDENT 200
 * STAFF 300
 * GUEST 150
 *
 * Expected Output:
 * STUDENT: 180.00
 * STAFF: 285.00
 * GUEST: 160.00
 * Total: 625.00
 */
public class CanteenBillingCounter {

    static abstract class Customer {
        protected final double bill;

        Customer(double bill) {
            this.bill = bill;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double bill) { super(bill); }
        String type() { return "STUDENT"; }
        double finalAmount() { return bill - bill * 0.10; }
    }

    static class Staff extends Customer {
        Staff(double bill) { super(bill); }
        String type() { return "STAFF"; }
        double finalAmount() { return bill - bill * 0.05; }
    }

    static class Guest extends Customer {
        Guest(double bill) { super(bill); }
        String type() { return "GUEST"; }
        double finalAmount() { return bill + 10; }
    }

    static Customer create(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new Student(amount);
            case "STAFF" -> new Staff(amount);
            case "GUEST" -> new Guest(amount);
            default -> throw new IllegalArgumentException("Unknown customer type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            customers.add(create(type, amount));
        }

        double total = 0;
        for (Customer c : customers) {
            double amount = c.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", c.type(), amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
