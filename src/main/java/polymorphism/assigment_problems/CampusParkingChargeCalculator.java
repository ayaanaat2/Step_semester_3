package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 — The Campus Parking Charge Calculator.
 *   Bike : 10 per hour
 *   Car  : 30 for the first hour + 20 for each additional hour
 *   Truck: 50 per hour, minimum charge 100
 *
 * Sample Input:
 * 4
 * BIKE 3
 * CAR 4
 * TRUCK 1
 * CAR 1
 *
 * Expected Output:
 * BIKE: 30.00
 * CAR: 90.00
 * TRUCK: 100.00
 * CAR: 30.00
 * Total: 250.00
 */
public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        protected final int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract String type();

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        String type() { return "BIKE"; }
        double charge() { return 10.0 * hours; }
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        String type() { return "CAR"; }
        double charge() { return 30.0 + 20.0 * (hours - 1); }
    }

    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        String type() { return "TRUCK"; }
        double charge() { return Math.max(50.0 * hours, 100.0); }
    }

    static Vehicle create(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(create(type, hours));
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.charge();
            System.out.printf(Locale.US, "%s: %.2f%n", v.type(), charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
