package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 3 — Even and Odd Numbers in a List.
 * Reads a list written like [3, 8, 12, 5, 7, 10] and counts evens and odds.
 *
 * Sample Input:
 * [3, 8, 12, 5, 7, 10]
 *
 * Expected Output:
 * Even: 3
 * Odd: 3
 */
public class EvenOddCounter {

    static int[] parseList(String line) {
        String cleaned = line.replace("[", " ").replace("]", " ").replace(",", " ").trim();
        if (cleaned.isEmpty()) return new int[0];
        String[] parts = cleaned.split("\\s+");
        int[] values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }
        return values;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = parseList(sc.nextLine());

        int even = 0, odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
