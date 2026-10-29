package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 — Library Late Fine Counter.
 * Abstract LibraryItem mandates fine(); each item type supplies its own rule.
 *   Book: 2/day, DVD: 5/day capped at 50, Magazine: 1/day
 *
 * Sample Input:
 * 3
 * BOOK Algebra 4
 * DVD Inception 12
 * MAGAZINE Sports 3
 *
 * Expected Output:
 * Algebra: 8.00
 * Inception: 50.00
 * Sports: 3.00
 * Total Fines: 61.00
 */
public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        protected final String title;
        protected final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String t, int d) { super(t, d); }
        double fine() { return 2.0 * daysLate; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String t, int d) { super(t, d); }
        double fine() { return Math.min(5.0 * daysLate, 50.0); }
    }

    static class Magazine extends LibraryItem {
        Magazine(String t, int d) { super(t, d); }
        double fine() { return 1.0 * daysLate; }
    }

    static LibraryItem create(String type, String title, int daysLate) {
        return switch (type) {
            case "BOOK" -> new Book(title, daysLate);
            case "DVD" -> new Dvd(title, daysLate);
            case "MAGAZINE" -> new Magazine(title, daysLate);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            items.add(create(type, title, daysLate));
        }

        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
            total += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
