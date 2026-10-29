package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 2 — Library Item Due Date Calculator.
 * Each item type overrides loanDays(); the due date is computed once, in the
 * base class, from the assumed current date 2023-10-26.
 *
 * Sample Input:
 * 3
 * BOOK "1984"
 * DVD "The Matrix"
 * MAGAZINE "Forbes Issue 500"
 *
 * Expected Output:
 * 1984: 2023-11-09
 * The Matrix: 2023-11-02
 * Forbes Issue 500: 2023-10-29
 */
public class LibraryItemDueDateCalculator {

    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {
        protected final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int loanDays();

        LocalDate dueDate(LocalDate from) {
            return from.plusDays(loanDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int loanDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        int loanDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int loanDays() { return 3; }
    }

    static LibraryItem create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }

    static String nextLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.isBlank()) return line.trim();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(nextLine(sc));
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = nextLine(sc);
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            items.add(create(type, title));
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate(TODAY));
        }
    }
}
