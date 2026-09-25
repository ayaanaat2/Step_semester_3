package encapsulation.assigment_problems;

/**
 * Problem 4 — The Traffic Light.
 * Color is private and can only move forward through the cycle via
 * next() — there is no method that sets it to an arbitrary value.
 *
 * Expected Output (running this file's main method):
 *
 * RED
 * GREEN
 * YELLOW
 * RED
 */
public class TrafficLight {

    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    /** Moves the light forward one step in the cycle and returns the new color. */
    public String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
