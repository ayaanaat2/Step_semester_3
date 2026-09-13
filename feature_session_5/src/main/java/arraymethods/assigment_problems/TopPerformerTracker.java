package arraymethods.assigment_problems;

/**
 * Problem 3 (Intermediate) — Top Performer Tracker.
 * Finds min, max, and spread in a single pass, without sorting.
 *
 * Expected Output (running this file's main method):
 *
 * Min: 33 | Max: 90 | Spread: 57
 */
public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }

        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
    }
}
