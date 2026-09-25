package encapsulation.assigment_problems;

/**
 * Problem 3 — The Password Checker.
 * The password is stored privately and final — there is no getter that
 * returns it anywhere. Only a strength rating derived from it is exposed.
 *
 * Expected Output (running this file's main method):
 *
 * Weak
 * Medium
 * Strong
 */
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());           // 4 chars
        System.out.println(new PasswordChecker("abcdefgh").getStrength());       // 8 chars
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());   // 12 chars
    }
}
