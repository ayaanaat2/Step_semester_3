package datastructure.assigment_problems;

/**
 * Problem 7 — Second-Best Score.
 * One pass with two variables (highest, second), no sorting. A score equal to
 * the current highest is skipped, so only DISTINCT scores count. Scores are
 * 0..100, so -1 is a safe "does not exist" marker.
 *
 * Expected Output (running this file's main method):
 * 78
 * -1
 *
 * Complexity: O(n) time, O(1) space. Sorting first would cost O(n log n) time
 * (and O(n) or O(log n) extra space depending on the sort) just to read two values.
 */
public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score != highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}
