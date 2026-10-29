package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 6 — Prime Number Checker.
 * Trial division from 2 up to the square root of the number.
 * Reads numbers (each greater than 1) until the end of input.
 *
 * Sample Input:
 * 29
 * 21
 *
 * Expected Output:
 * 29 is prime
 * 21 is not prime
 */
public class PrimeNumberChecker {

    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long d = 2; d * d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
        }
    }
}
