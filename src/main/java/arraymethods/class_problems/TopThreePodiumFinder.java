package arraymethods.class_problems;

import java.util.Arrays;

/**
 * Problem 3 (Intermediate) — Top-3 Podium Finder.
 * Tracks the top 3 scores in a single pass, without sorting.
 *
 * Expected Output (running this file's main method):
 *
 * [90, 90, 82]
 */
public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61})));
    }
}
