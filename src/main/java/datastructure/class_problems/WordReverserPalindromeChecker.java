package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 2 — Word Reverser and Palindrome Checker.
 * Reverses each word with a StringBuilder, prints the reversed word, and says
 * whether the original reads the same both ways (case-sensitive comparison).
 * Reads words until the end of input.
 *
 * Sample Input:
 * level
 * java
 *
 * Expected Output:
 * level - palindrome
 * avaj - not a palindrome
 */
public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            String verdict = word.equals(reversed) ? "palindrome" : "not a palindrome";
            System.out.println(reversed + " - " + verdict);
        }
    }
}
