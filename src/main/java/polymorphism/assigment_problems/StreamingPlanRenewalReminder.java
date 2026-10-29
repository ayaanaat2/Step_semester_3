package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5 — The Streaming Plan Renewal Reminder.
 *   Basic: 30 days, Standard: 90 days, Premium: 365 days.
 * renewalDate() lives once in the base class; each plan only overrides validityDays().
 * LocalDate.plusDays() handles the leap year and the year change.
 *
 * Sample Input:
 * 4
 * BASIC Asha 2024-01-15
 * STANDARD Ravi 2024-02-01
 * PREMIUM Neha 2024-03-10
 * BASIC Kiran 2024-12-20
 *
 * Expected Output:
 * Asha: 2024-02-14
 * Ravi: 2024-05-01
 * Neha: 2025-03-10
 * Kiran: 2025-01-19
 */
public class StreamingPlanRenewalReminder {

    static abstract class Subscriber {
        protected final String name;
        protected final LocalDate startDate;

        Subscriber(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicSubscriber extends Subscriber {
        BasicSubscriber(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 30; }
    }

    static class StandardSubscriber extends Subscriber {
        StandardSubscriber(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 90; }
    }

    static class PremiumSubscriber extends Subscriber {
        PremiumSubscriber(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 365; }
    }

    static Subscriber create(String plan, String name, LocalDate start) {
        return switch (plan) {
            case "BASIC" -> new BasicSubscriber(name, start);
            case "STANDARD" -> new StandardSubscriber(name, start);
            case "PREMIUM" -> new PremiumSubscriber(name, start);
            default -> throw new IllegalArgumentException("Unknown plan: " + plan);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String plan = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            subscribers.add(create(plan, name, start));
        }

        for (Subscriber s : subscribers) {
            System.out.println(s.name + ": " + s.renewalDate());
        }
    }
}
