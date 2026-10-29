package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 — Weekly Staff Pay.
 * Staff is abstract, so a generic "staff member" with no pay rule can never be
 * created, and every subclass is forced to define weeklyPay().
 *   Full-time: fixed weekly salary
 *   Hourly   : rate for first 40 hours, 1.5 x rate for every hour above 40
 *   Intern   : fixed stipend
 *
 * Sample Input:
 * 3
 * FULLTIME Asha 12000
 * HOURLY Ravi 45 200
 * INTERN Neha 5000
 *
 * Expected Output:
 * Asha: 12000.00
 * Ravi: 9500.00
 * Neha: 5000.00
 * Total Payroll: 26500.00
 */
public class WeeklyStaffPay {

    static abstract class Staff {
        protected final String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double weeklyPay();
    }

    static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double weeklyPay() { return weeklySalary; }
    }

    static class HourlyStaff extends Staff {
        private final double hours, rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double weeklyPay() {
            double regular = Math.min(hours, 40);
            double overtime = Math.max(hours - 40, 0);
            return regular * rate + overtime * rate * 1.5;
        }
    }

    static class InternStaff extends Staff {
        private final double stipend;

        InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double weeklyPay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s = switch (type) {
                case "FULLTIME" -> new FullTimeStaff(name, sc.nextDouble());
                case "HOURLY" -> new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                case "INTERN" -> new InternStaff(name, sc.nextDouble());
                default -> throw new IllegalArgumentException("Unknown staff type: " + type);
            };
            staff.add(s);
        }

        double total = 0;
        for (Staff s : staff) {
            double pay = s.weeklyPay();
            System.out.printf(Locale.US, "%s: %.2f%n", s.name, pay);
            total += pay;
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
