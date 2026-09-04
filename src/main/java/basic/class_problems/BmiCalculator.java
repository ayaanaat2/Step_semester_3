package basic.class_problems;

import java.util.Random;

/**
 * The Corporate Wellness Program — computes BMI and health status for a team.
 */
public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%6d | %10.2f | %11.2f | %5.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random random = new Random();
        // Sample fixed pair from the spec, then random values for the rest of the team
        heights[0] = 1.75; weights[0] = 70;
        heights[1] = 1.60; weights[1] = 90;
        for (int i = 2; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.4; // 1.50m - 1.90m
            weights[i] = 50 + random.nextInt(50);           // 50kg - 99kg
        }

        printWellnessReport(heights, weights);
    }
}
