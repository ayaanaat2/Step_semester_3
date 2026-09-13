package arraymethods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 1 (Easy) — Fantasy Team Score Multiplier.
 * Applies Captain (2x) and Vice-Captain (1.5x) multipliers directly to
 * the caller's original array — two direct index assignments, no loop.
 *
 * Expected Output (running this file's main method):
 *
 * [40.0, 110.0, 30.0, 93.0]
 */
public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
