package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 — Electricity Connection Billing.
 * Abstract Connection keeps the shared units value and an abstract bill().
 *   Home   : 5/unit for the first 100 units, 7/unit after that
 *   Shop   : 8/unit + fixed charge 100
 *   Factory: 6/unit, minimum bill 1000
 *
 * Sample Input:
 * 3
 * HOME 150
 * SHOP 90
 * FACTORY 120
 *
 * Expected Output:
 * HOME: 850.00
 * SHOP: 820.00
 * FACTORY: 1000.00
 * Total: 2670.00
 */
public class ElectricityConnectionBilling {

    static abstract class Connection {
        protected final int units;

        Connection(int units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(int units) { super(units); }
        String type() { return "HOME"; }

        double bill() {
            int first = Math.min(units, 100);
            int rest = Math.max(units - 100, 0);
            return first * 5.0 + rest * 7.0;
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(int units) { super(units); }
        String type() { return "SHOP"; }
        double bill() { return units * 8.0 + 100; }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(int units) { super(units); }
        String type() { return "FACTORY"; }
        double bill() { return Math.max(units * 6.0, 1000); }
    }

    static Connection create(String type, int units) {
        return switch (type) {
            case "HOME" -> new HomeConnection(units);
            case "SHOP" -> new ShopConnection(units);
            case "FACTORY" -> new FactoryConnection(units);
            default -> throw new IllegalArgumentException("Unknown connection type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            connections.add(create(type, units));
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", c.type(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
