package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5 — Home Appliance Energy Report.
 * Shared by all appliances (abstract class): power rating, hours, units, cost.
 * Only some appliances can run in saver mode, so that is an interface
 * (SaverMode). The report asks "does this appliance support saver mode?" with
 * instanceof instead of a list of if-else checks.
 *   Power: Fridge 150 W, AC 1500 W, TV 100 W, Washer 500 W
 *   Units = power x hours / 1000 (saver mode: -25%), Cost = units x 8
 *
 * Sample Input:
 * 4
 * FRIDGE 24
 * AC 8 SAVER
 * TV 5
 * WASHER 2 SAVER
 *
 * Expected Output:
 * FRIDGE: Units=3.60 Cost=28.80
 * AC: Units=9.00 Cost=72.00
 * TV: Units=0.50 Cost=4.00
 * WASHER: Units=0.75 Cost=6.00
 * Total Cost: 110.80
 */
public class HomeApplianceEnergyReport {

    interface SaverMode {
        double SAVER_REDUCTION = 0.25;
    }

    static abstract class Appliance {
        static final double RATE_PER_UNIT = 8;

        protected final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract String name();

        abstract double powerWatts();

        double units(boolean saver) {
            double units = powerWatts() * hours / 1000.0;
            return saver ? units * (1 - SaverMode.SAVER_REDUCTION) : units;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double h) { super(h); }
        String name() { return "FRIDGE"; }
        double powerWatts() { return 150; }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double h) { super(h); }
        String name() { return "AC"; }
        double powerWatts() { return 1500; }
    }

    static class Tv extends Appliance {
        Tv(double h) { super(h); }
        String name() { return "TV"; }
        double powerWatts() { return 100; }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        WashingMachine(double h) { super(h); }
        String name() { return "WASHER"; }
        double powerWatts() { return 500; }
    }

    static Appliance create(String type, double hours) {
        return switch (type) {
            case "FRIDGE" -> new Fridge(hours);
            case "AC" -> new AirConditioner(hours);
            case "TV" -> new Tv(hours);
            case "WASHER" -> new WashingMachine(hours);
            default -> throw new IllegalArgumentException("Unknown appliance: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Appliance a = create(parts[0], Double.parseDouble(parts[1]));
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(a.name() + ": saver mode not supported");
                continue;
            }
            double units = a.units(saver);
            double cost = units * Appliance.RATE_PER_UNIT;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", a.name(), units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
