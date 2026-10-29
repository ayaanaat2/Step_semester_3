package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 — College Fee Counter.
 * Every student has a name and a tuition rule (abstract class Student).
 * Only some students use the bus, so "uses the bus" is an interface (BusUser)
 * that carries the transport fee in exactly one place. The counter asks
 * "is this student a BusUser?" instead of checking the type by name.
 *   Day scholar: 40000 + transport    Hosteller: 40000 + 60000
 *   Scholar    : 20000 + transport    Transport fee: 12000
 *
 * Sample Input:
 * 3
 * DAY_SCHOLAR Asha
 * HOSTELLER Ravi
 * SCHOLAR Neha
 *
 * Expected Output:
 * Asha: 52000.00
 * Ravi: 100000.00
 * Neha: 32000.00
 * Total Collected: 184000.00
 */
public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    static abstract class Student {
        protected final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();

        double totalFee() {
            double fee = tuition();
            if (this instanceof BusUser) {
                fee += BusUser.TRANSPORT_FEE;
            }
            return fee;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000 + 60000; }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) { super(name); }
        double tuition() { return 40000 / 2.0; }
    }

    static Student create(String type, String name) {
        return switch (type) {
            case "DAY_SCHOLAR" -> new DayScholar(name);
            case "HOSTELLER" -> new Hosteller(name);
            case "SCHOLAR" -> new ScholarshipStudent(name);
            default -> throw new IllegalArgumentException("Unknown student type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            students.add(create(type, name));
        }

        double total = 0;
        for (Student s : students) {
            double fee = s.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", s.name, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
