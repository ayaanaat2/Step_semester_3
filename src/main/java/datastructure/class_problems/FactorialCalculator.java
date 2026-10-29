package datastructure.class_problems;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem 7 — Factorial Calculation.
 * Multiplies 1..n in a loop (0! = 1). BigInteger keeps large inputs correct.
 * Reads numbers until the end of input.
 *
 * Sample Input:
 * 5
 * 0
 *
 * Expected Output:
 * 120
 * 1
 */
public class FactorialCalculator {

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(factorial(sc.nextInt()));
        }
    }
}
