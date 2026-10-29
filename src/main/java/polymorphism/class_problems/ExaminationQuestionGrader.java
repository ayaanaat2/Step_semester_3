package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4 — Examination Question Grader.
 * Each question type overrides score(); the grader loop treats all questions
 * uniformly. Quoted fields are read with a small tokenizer.
 *   MCQ / TF : full points on an exact match
 *   ESSAY    : 2+ keywords found -> 75% of points, 1 keyword -> 50%, else 0
 *
 * Sample Input:
 * 4
 * MCQ "What is the capital of France?" "Paris" "Paris" 10
 * TF "The Earth is flat?" "False" "True" 5
 * ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
 * ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction." 15
 *
 * Expected Output:
 * MCQ: 10.00
 * TF: 0.00
 * ESSAY: 10.00
 * ESSAY: 7.50
 * Total Score: 27.50
 */
public class ExaminationQuestionGrader {

    static abstract class Question {
        protected final String text;
        protected final String correct;
        protected final String student;
        protected final double points;

        Question(String text, String correct, String student, double points) {
            this.text = text;
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        abstract String type();

        abstract double score();
    }

    static class McqQuestion extends Question {
        McqQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
        String type() { return "MCQ"; }
        double score() { return student.equals(correct) ? points : 0; }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
        String type() { return "TF"; }
        double score() { return student.equals(correct) ? points : 0; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
        String type() { return "ESSAY"; }

        double score() {
            String answer = student.toLowerCase();
            int found = 0;
            for (String keyword : correct.split(",")) {
                String k = keyword.trim().toLowerCase();
                if (!k.isEmpty() && answer.contains(k)) {
                    found++;
                }
            }
            if (found >= 2) return points * 0.75;
            if (found == 1) return points * 0.50;
            return 0;
        }
    }

    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        int i = 0, n = line.length();
        while (i < n) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (c == '"') {
                int end = line.indexOf('"', i + 1);
                if (end == -1) end = n;
                tokens.add(line.substring(i + 1, end));
                i = end + 1;
            } else {
                int end = i;
                while (end < n && !Character.isWhitespace(line.charAt(end))) end++;
                tokens.add(line.substring(i, end));
                i = end;
            }
        }
        return tokens;
    }

    static String nextLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.isBlank()) return line.trim();
        }
        return null;
    }

    static Question create(List<String> t) {
        String text = t.get(1), correct = t.get(2), student = t.get(3);
        double points = Double.parseDouble(t.get(4));
        return switch (t.get(0)) {
            case "MCQ" -> new McqQuestion(text, correct, student, points);
            case "TF" -> new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY" -> new EssayQuestion(text, correct, student, points);
            default -> throw new IllegalArgumentException("Unknown question type: " + t.get(0));
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(nextLine(sc));
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(create(tokenize(nextLine(sc))));
        }

        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            System.out.printf(Locale.US, "%s: %.2f%n", q.type(), s);
            total += s;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
