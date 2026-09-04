package string.assigment_problems;

/**
 * ATM app — checks a PIN is exactly 4 digits long.
 */
public class AtmPinLengthValidator {

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}
