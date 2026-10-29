package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 1 — Vowel and Consonant Counter.
 * Reads one alphabetic word and counts vowels and consonants (case-insensitive).
 *
 * Sample Input:
 * Programming
 *
 * Expected Output:
 * Vowels: 3
 * Consonants: 8
 */
public class VowelConsonantCounter {

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();

        int vowels = 0, consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetter(c)) continue;
            if (isVowel(c)) vowels++;
            else consonants++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
