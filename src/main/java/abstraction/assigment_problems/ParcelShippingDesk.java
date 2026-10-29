package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2 — Parcel Shipping Desk.
 * Two separate questions, two separate places:
 *   "how much does shipping cost?"  -> abstract class Parcel (every parcel answers)
 *   "can it be insured?"            -> interface Insurable (only some parcels)
 * Making another parcel type insurable later only means implementing Insurable
 * on that class; the other parcel types are untouched.
 *   Standard: 40 + 10/kg    Express: 80 + 15/kg    Fragile: standard + 50
 *   Insurance (Express, Fragile): 2% of declared value
 *
 * Sample Input:
 * 3
 * STANDARD 3 500
 * EXPRESS 2 1000
 * FRAGILE 4 2000
 *
 * Expected Output:
 * STANDARD: Charge=70.00 Insurance=0.00 Total=70.00
 * EXPRESS: Charge=110.00 Insurance=20.00 Total=130.00
 * FRAGILE: Charge=130.00 Insurance=40.00 Total=170.00
 * Grand Total: 370.00
 */
public class ParcelShippingDesk {

    interface Insurable {
        double INSURANCE_RATE = 0.02;

        double insurance();
    }

    static abstract class Parcel {
        protected final double weightKg;
        protected final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract String type();

        abstract double charge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double w, double v) { super(w, v); }
        String type() { return "STANDARD"; }
        double charge() { return 40 + 10 * weightKg; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double w, double v) { super(w, v); }
        String type() { return "EXPRESS"; }
        double charge() { return 80 + 15 * weightKg; }
        public double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    static class FragileParcel extends StandardParcel implements Insurable {
        FragileParcel(double w, double v) { super(w, v); }
        @Override String type() { return "FRAGILE"; }
        @Override double charge() { return super.charge() + 50; }
        public double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    static Parcel create(String type, double weight, double value) {
        return switch (type) {
            case "STANDARD" -> new StandardParcel(weight, value);
            case "EXPRESS" -> new ExpressParcel(weight, value);
            case "FRAGILE" -> new FragileParcel(weight, value);
            default -> throw new IllegalArgumentException("Unknown parcel type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            parcels.add(create(type, weight, value));
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.charge();
            double insurance = (p instanceof Insurable ins) ? ins.insurance() : 0;
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.type(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
