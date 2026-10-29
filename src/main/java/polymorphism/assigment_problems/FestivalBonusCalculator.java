package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 — The Festival Bonus Calculator.
 *   Full-time: 10% of monthly salary
 *   Part-time: 5% of monthly salary
 *   Intern   : fixed 2000
 *
 * Sample Input:
 * 3
 * FULLTIME Asha 50000
 * PARTTIME Ravi 30000
 * INTERN Neha 15000
 *
 * Expected Output:
 * Asha: 5000.00
 * Ravi: 1500.00
 * Neha: 2000.00
 * Total Bonus: 8500.00
 */
public class FestivalBonusCalculator {

    static abstract class Employee {
        protected final String name;
        protected final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String n, double s) { super(n, s); }
        double bonus() { return monthlySalary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String n, double s) { super(n, s); }
        double bonus() { return monthlySalary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String n, double s) { super(n, s); }
        double bonus() { return 2000; }
    }

    static Employee create(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTimeEmployee(name, salary);
            case "PARTTIME" -> new PartTimeEmployee(name, salary);
            case "INTERN" -> new Intern(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees.add(create(type, name, salary));
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.bonus();
            System.out.printf(Locale.US, "%s: %.2f%n", e.name, bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
