package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 — Garden Plot Area Report.
 * Abstract Plot holds the owner and forces every shape to supply area().
 * The report loop only knows about Plot, so a new shape needs no change there.
 *
 * Sample Input:
 * 3
 * CIRCLE Asha 5
 * RECTANGLE Ravi 4 6
 * TRIANGLE Neha 10 3
 *
 * Expected Output:
 * Asha (CIRCLE): 78.54
 * Ravi (RECTANGLE): 24.00
 * Neha (TRIANGLE): 15.00
 * Total Area: 117.54
 */
public class GardenPlotAreaReport {

    static abstract class Plot {
        protected final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract String shape();

        abstract double area();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        String shape() { return "CIRCLE"; }
        double area() { return Math.PI * radius * radius; }
    }

    static class RectanglePlot extends Plot {
        private final double length, width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        String shape() { return "RECTANGLE"; }
        double area() { return length * width; }
    }

    static class TrianglePlot extends Plot {
        private final double base, height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        String shape() { return "TRIANGLE"; }
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot p = switch (shape) {
                case "CIRCLE" -> new CirclePlot(owner, sc.nextDouble());
                case "RECTANGLE" -> new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
                case "TRIANGLE" -> new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
                default -> throw new IllegalArgumentException("Unknown shape: " + shape);
            };
            plots.add(p);
        }

        double total = 0;
        for (Plot p : plots) {
            double area = p.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", p.owner, p.shape(), area);
            total += area;
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
