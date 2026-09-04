package string.assigment_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * T&P team — word-frequency report of feedback text, excluding common stop words.
 */
public class StopWordFilteredWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) {
            if (stopWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
