package encapsulation.class_problems;

/**
 * Problem 2 — The Quiz Scorecard.
 * Stores each answer's result privately; only the final score is exposed,
 * never the raw array of right/wrong answers.
 *
 * Expected Output (running this file's main method):
 *
 * Score: 3
 */
public class Scorecard {

    private boolean[] results;
    private int recordedCount;
    private final int totalQuestions;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount >= totalQuestions) {
            return; // fixed question count reached, ignore further answers
        }
        results[recordedCount] = correct;
        recordedCount++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}
