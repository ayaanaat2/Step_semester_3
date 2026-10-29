package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3 — Delivery Fee Calculator.
 * Each delivery type overrides fee(); the main loop never checks the type.
 * Fees follow the written business rules exactly:
 *   Standard      = 5  + 0.50*kg + 0.10*km
 *   Express       = 15 + 1.00*kg + 0.20*km
 *   International = 25 + 2.00*kg + 0.50*km + customsFee
 *
 * Sample Input:
 * 3
 * STANDARD 10 50
 * EXPRESS 5 20
 * INTERNATIONAL 20 100 30
 *
 * Output of this program (follows the written rules):
 * STANDARD: 15.00
 * EXPRESS: 24.00
 * INTERNATIONAL: 145.00
 * Total: 184.00
 *
 * NOTE: the problem sheet prints EXPRESS: 29.00, INTERNATIONAL: 155.00 and
 * Total: 199.00 for this input, which does not match its own rules (the rules
 * give 24.00 and 145.00). STANDARD matches. The code follows the rules; if
 * your checker wants the sheet's numbers, the base fees would have to be
 * 20 (Express) and 35 (International) instead of 15 and 25.
 */
public class DeliveryFeeCalculator {

    static abstract class Delivery {
        protected final double weight;
        protected final double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract String type();

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) { super(w, d); }
        String type() { return "STANDARD"; }
        double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) { super(w, d); }
        String type() { return "EXPRESS"; }
        double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        InternationalDelivery(double w, double d, double customsFee) {
            super(w, d);
            this.customsFee = customsFee;
        }

        String type() { return "INTERNATIONAL"; }
        double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d = switch (type) {
                case "STANDARD" -> new StandardDelivery(weight, distance);
                case "EXPRESS" -> new ExpressDelivery(weight, distance);
                case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, sc.nextDouble());
                default -> throw new IllegalArgumentException("Unknown delivery type: " + type);
            };
            deliveries.add(d);
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", d.type(), fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
