package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 5 — Digit Sum and Number Reversal.
 * Peels digits with % 10 and / 10; builds the reverse as reversed * 10 + digit.
 *
 * Sample Input:
 * 4721
 *
 * Expected Output:
 * Sum of digits: 14
 * Reverse: 1274
 */
public class DigitSumAndReversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();

        long sum = 0, reversed = 0;
        while (number > 0) {
            long digit = number % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}
