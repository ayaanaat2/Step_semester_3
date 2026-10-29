package datastructure.assigment_problems;

/**
 * Problem 4 — Exam Score Band Counter.
 * Counts scores s with low <= s <= high in a sorted array using two binary
 * searches: firstAtLeast(low) and firstGreaterThan(high). The answer is the
 * difference of the two positions.
 *
 * Expected Output (running this file's main method):
 * 6
 * 0
 *
 * Complexity:
 *   Linear scan : O(n) time, O(1) space.
 *   Final answer: O(log n) time (two binary searches), O(1) space.
 * Duplicates at the edges: a normal binary search stops at ANY matching
 * element, which could land in the middle of a run of equal scores. Searching
 * for the first position >= low and the first position > high always lands on
 * the boundary of the run, so every duplicate inside the band is counted and
 * none outside it.
 */
public class ExamScoreBandCounter {

    /** First index i with scores[i] >= target (scores.length if none). */
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    /** First index i with scores[i] > target (scores.length if none). */
    static int firstGreaterThan(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
