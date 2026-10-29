package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 — The Hostel Electricity Bill.
 *   Single: 8 per unit
 *   Shared: 6 per unit, split equally (amount shown is per occupant)
 *   AC    : 10 per unit + fixed charge 200
 * The extra occupants value lives inside SharedRoom, so the main loop can still
 * treat every room the same way through bill().
 *
 * Sample Input:
 * 3
 * SINGLE 120
 * SHARED 150 3
 * AC 100
 *
 * Expected Output:
 * SINGLE: 960.00
 * SHARED: 300.00
 * AC: 1200.00
 * Total: 2460.00
 */
public class HostelElectricityBill {

    static abstract class Room {
        protected final int units;

        Room(int units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        String type() { return "SINGLE"; }
        double bill() { return 8.0 * units; }
    }

    static class SharedRoom extends Room {
        private final int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        String type() { return "SHARED"; }
        double bill() { return 6.0 * units / occupants; }
    }

    static class AcRoom extends Room {
        AcRoom(int units) { super(units); }
        String type() { return "AC"; }
        double bill() { return 10.0 * units + 200; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r = switch (type) {
                case "SINGLE" -> new SingleRoom(units);
                case "SHARED" -> new SharedRoom(units, sc.nextInt());
                case "AC" -> new AcRoom(units);
                default -> throw new IllegalArgumentException("Unknown room type: " + type);
            };
            rooms.add(r);
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", r.type(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
