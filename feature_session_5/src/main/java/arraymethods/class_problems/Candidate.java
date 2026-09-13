package arraymethods.class_problems;

import java.util.Arrays;

/**
 * Problem 5 (Advanced) — Placement Drive Shortlisting & Ranking Engine.
 *
 * Eligibility rule: a strong CGPA alone is enough (quick filter); a
 * borderline CGPA can still qualify through a genuinely good coding-test
 * score (combined filter). Shortlisted candidates are ranked by a
 * composite score (cgpa * 10 + codingScore * 0.5), descending, purely via
 * Arrays.sort() + Comparable.
 *
 * Expected Output (running this file's main method):
 *
 * 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
 */
public class Candidate implements Comparable<Candidate> {

    private final String name;
    private final double cgpa;
    private final int codingScore;
    private final double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
    }

    /** Quick filter for a strong CGPA alone. */
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    /** Combined filter for borderline CGPA candidates with a strong coding score. */
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore); // descending
    }

    static String shortlistAndRank(Candidate[] candidates) {
        java.util.List<Candidate> shortlisted = new java.util.ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            result.append(i + 1).append(". ").append(shortlistedArray[i].name)
                  .append(" (").append(shortlistedArray[i].compositeScore).append(")");
            if (i != shortlistedArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
