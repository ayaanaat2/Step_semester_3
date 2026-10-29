package datastructure.assigment_problems;

/**
 * Problem 6 — Class Attendance Tracker.
 * One pass: a running streak grows on every 1 and resets on every 0; the
 * largest value it reaches is the longest streak, and every 1 is also counted
 * as a present day.
 *
 * Expected Output (running this file's main method):
 * Present: 6, Longest streak: 3
 * Present: 0, Longest streak: 0
 *
 * Complexity: O(n) time, O(1) space. Yes, both answers come from a single pass.
 */
public class ClassAttendanceTracker {

    static String attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                if (streak > longest) longest = streak;
            } else {
                streak = 0;
            }
        }
        return "Present: " + present + ", Longest streak: " + longest;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}
