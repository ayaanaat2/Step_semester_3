package datastructure.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 4 — In-Place Array Reversal.
 * Two pointers swap elements from both ends until they meet; no second array.
 *
 * Sample Input:
 * [11, 22, 33, 44]
 *
 * Expected Output:
 * [44, 33, 22, 11]
 */
public class InPlaceArrayReversal {

    static void reverseInPlace(int[] tokens) {
        int left = 0, right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

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
        int[] tokens = parseList(sc.nextLine());
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
