package arraymethods.class_problems;

import java.util.Arrays;

/**
 * Problem 1 (Easy) — Hackathon Score Curve Booster.
 * Boosts every score in place (no new array, no return value).
 *
 * Expected Output (running this file's main method):
 *
 * [80, 95, 70]
 */
public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
    }
}
