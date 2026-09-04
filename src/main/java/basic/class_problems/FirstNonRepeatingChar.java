package basic.class_problems;

/**
 * The Unique Letter Hunt Mini-Game — finds the first non-repeating character.
 */
public class FirstNonRepeatingChar {

    public static Character findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        for (String text : inputs) {
            Character result = findFirstNonRepeatingChar(text);
            if (result != null) {
                System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}
