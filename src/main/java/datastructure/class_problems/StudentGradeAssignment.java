package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 8 — Student Grade Assignment.
 * if / else-if ladder from the highest boundary down.
 *   A: 90+   B: 75-89   C: 60-74   D: 40-59   F: below 40
 * Reads marks until the end of input.
 *
 * Sample Input:
 * 72
 * 95
 * 35
 *
 * Expected Output:
 * Grade C
 * Grade A
 * Grade F
 */
public class StudentGradeAssignment {

    static char gradeFor(int marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else if (marks >= 40) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println("Grade " + gradeFor(sc.nextInt()));
        }
    }
}
