package arraymethods.class_problems;

/**
 * Problem 4 (Intermediate) — Hackathon Seating Grid Optimizer.
 * Classifies each seating row as "Quiet Zone" or "Buzzing Zone" using a
 * single reusable rowAverage() helper (rows may be jagged).
 *
 * Expected Output (running this file's main method):
 *
 * Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
 */
public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            result.append("Row ").append(i).append(": ").append(zone);
            if (i != seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }
}
