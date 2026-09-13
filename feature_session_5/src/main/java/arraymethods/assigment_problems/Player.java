package arraymethods.assigment_problems;

import java.util.Arrays;

/**
 * Problem 5 (Advanced) — Fantasy League Auto-Draft Ranking Engine.
 *
 * Draft rule: a long track record qualifies on experience alone
 * (matchesPlayed >= 10, regardless of fitness); a newer player still
 * needs to be both reasonably experienced and currently fit
 * (matchesPlayed >= 5 && !injured). Draftable players are ranked by
 * batting average, descending, purely via Arrays.sort() + Comparable.
 *
 * Expected Output (running this file's main method):
 *
 * 1. Rahul | 2. Virat | 3. Dev
 */
public class Player implements Comparable<Player> {

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    /** Experience-only rule for established players. */
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /** Combined matches-and-fitness rule for newer players. */
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage); // descending
    }

    static String draftAndRank(Player[] players) {
        java.util.List<Player> draftable = new java.util.ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i != draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
