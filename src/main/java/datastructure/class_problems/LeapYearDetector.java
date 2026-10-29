package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 9 — Leap Year Detector.
 * Leap if divisible by 4 and not by 100, unless also divisible by 400.
 * Reads years until the end of input.
 *
 * Sample Input:
 * 2024
 * 1900
 * 2000
 *
 * Expected Output:
 * Leap year
 * Not a leap year
 * Leap year
 */
public class LeapYearDetector {

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(isLeap(sc.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }
}
