package datastructure.class_problems;

import java.util.Scanner;

/**
 * Problem 10 — Student Result Card Generator.
 * A Student has a name and three marks; it calculates its own average and grade.
 * Grade scale (same as Problem 8): A 90+, B 75-89, C 60-74, D 40-59, F below 40.
 * Reads lines like "Asha [80, 90, 70]" until the end of input.
 *
 * Sample Input:
 * Asha [80, 90, 70]
 * Ravi [60, 55, 50]
 *
 * Expected Output:
 * ASHA: Average 80.0, Grade B
 * RAVI: Average 55.0, Grade D
 */
public class StudentResultCardGenerator {

    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }

        char grade() {
            double avg = average();
            if (avg >= 90) return 'A';
            else if (avg >= 75) return 'B';
            else if (avg >= 60) return 'C';
            else if (avg >= 40) return 'D';
            else return 'F';
        }

        void printCard() {
            System.out.printf(java.util.Locale.US, "%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average(), grade());
        }
    }

    static Student parse(String line) {
        int bracket = line.indexOf('[');
        String name = line.substring(0, bracket).trim();
        String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");
        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            marks[i] = Integer.parseInt(parts[i].trim());
        }
        return new Student(name, marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isBlank()) continue;
            parse(line).printCard();
        }
    }
}
