package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 — Travel Booking with a Common Fee.
 * Template-method style: the booking fee is written once (BOOKING_FEE) and
 * added in the final total() of the abstract base; subclasses only supply
 * baseFare(). Changing the fee means changing exactly one line.
 *   Bus: 2/km, Train: 1.5/km, Flight: 2500 + 4/km
 *
 * Sample Input:
 * 3
 * BUS 200
 * TRAIN 300
 * FLIGHT 500
 *
 * Expected Output:
 * BUS: 450.00
 * TRAIN: 500.00
 * FLIGHT: 4550.00
 */
public class TravelBookingWithCommonFee {

    static abstract class Booking {
        static final double BOOKING_FEE = 50;

        protected final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String mode();

        abstract double baseFare();

        final double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double km) { super(km); }
        String mode() { return "BUS"; }
        double baseFare() { return 2.0 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double km) { super(km); }
        String mode() { return "TRAIN"; }
        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double km) { super(km); }
        String mode() { return "FLIGHT"; }
        double baseFare() { return 2500 + 4.0 * distanceKm; }
    }

    static Booking create(String mode, double km) {
        return switch (mode) {
            case "BUS" -> new BusBooking(km);
            case "TRAIN" -> new TrainBooking(km);
            case "FLIGHT" -> new FlightBooking(km);
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double km = sc.nextDouble();
            bookings.add(create(mode, km));
        }

        for (Booking b : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", b.mode(), b.total());
        }
    }
}
