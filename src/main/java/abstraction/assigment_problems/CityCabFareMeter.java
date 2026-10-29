package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 — City Cab Fare Meter.
 * The minimum-fare rule applies to every cab, so it lives once in the abstract
 * Cab class. Night service is an ability only some cabs have, so it is an
 * interface (NightService); Mini simply does not implement it, and a new cab
 * type can choose to have it or not.
 *   Mini: 10/km, Sedan: 14/km, SUV: 18/km, minimum fare 100, night adds 20%
 *
 * Sample Input:
 * 4
 * MINI 8 DAY
 * SEDAN 10 NIGHT
 * SUV 20 DAY
 * MINI 5 NIGHT
 *
 * Expected Output:
 * MINI: 100.00
 * SEDAN: 168.00
 * SUV: 360.00
 * MINI: night service not available
 * Total: 628.00
 */
public class CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE = 0.20;
    }

    static abstract class Cab {
        static final double MINIMUM_FARE = 100;

        abstract String type();

        abstract double ratePerKm();

        double fare(double km) {
            return Math.max(km * ratePerKm(), MINIMUM_FARE);
        }
    }

    static class MiniCab extends Cab {
        String type() { return "MINI"; }
        double ratePerKm() { return 10; }
    }

    static class SedanCab extends Cab implements NightService {
        String type() { return "SEDAN"; }
        double ratePerKm() { return 14; }
    }

    static class SuvCab extends Cab implements NightService {
        String type() { return "SUV"; }
        double ratePerKm() { return 18; }
    }

    static Cab create(String type) {
        return switch (type) {
            case "MINI" -> new MiniCab();
            case "SEDAN" -> new SedanCab();
            case "SUV" -> new SuvCab();
            default -> throw new IllegalArgumentException("Unknown cab type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = create(sc.next());
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");

            double fare = cab.fare(km);
            if (night) {
                if (cab instanceof NightService) {
                    fare += fare * NightService.NIGHT_SURCHARGE;
                } else {
                    System.out.println(cab.type() + ": night service not available");
                    continue;
                }
            }
            System.out.printf(Locale.US, "%s: %.2f%n", cab.type(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
