package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 — Public Transport Fare Calculator.
 * Each transport type overrides fare(); the journey loop never checks the type.
 *   Bus   : 2    + 0.10/km, capped at 10
 *   Train : 3    + 0.15/km
 *   Metro : (1.5 + 0.20/km) * PeakHourFactor
 *
 * Sample Input:
 * 3
 * BUS 15
 * TRAIN 50
 * METRO 10 1.5
 *
 * Expected Output:
 * BUS: 3.50
 * TRAIN: 10.50
 * METRO: 5.25
 * Total: 19.25
 */
public class PublicTransportFareCalculator {

    static abstract class Journey {
        protected final double distance;

        Journey(double distance) {
            this.distance = distance;
        }

        abstract String type();

        abstract double fare();
    }

    static class BusJourney extends Journey {
        BusJourney(double d) { super(d); }
        String type() { return "BUS"; }
        double fare() { return Math.min(2 + 0.10 * distance, 10); }
    }

    static class TrainJourney extends Journey {
        TrainJourney(double d) { super(d); }
        String type() { return "TRAIN"; }
        double fare() { return 3 + 0.15 * distance; }
    }

    static class MetroJourney extends Journey {
        private final double peakHourFactor;

        MetroJourney(double d, double peakHourFactor) {
            super(d);
            this.peakHourFactor = peakHourFactor;
        }

        String type() { return "METRO"; }
        double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Journey j = switch (type) {
                case "BUS" -> new BusJourney(distance);
                case "TRAIN" -> new TrainJourney(distance);
                case "METRO" -> new MetroJourney(distance, sc.nextDouble());
                default -> throw new IllegalArgumentException("Unknown transport type: " + type);
            };
            journeys.add(j);
        }

        double total = 0;
        for (Journey j : journeys) {
            double fare = j.fare();
            System.out.printf(Locale.US, "%s: %.2f%n", j.type(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
