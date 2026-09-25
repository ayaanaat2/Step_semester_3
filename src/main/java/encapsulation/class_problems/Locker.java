package encapsulation.class_problems;

/**
 * Problem 4 — The Locker Code.
 * Write-only combination code: changeCode() requires the current code
 * first, and there is deliberately no getter for the code at all.
 *
 * Expected Output (running this file's main method):
 *
 * Change with correct code: true
 * Change with wrong code: false
 */
public class Locker {

    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    /** Returns true if the change succeeded, false if oldCode was wrong. */
    public boolean changeCode(String oldCode, String newCode) {
        if (!code.equals(oldCode)) {
            return false; // rejected, code stays the same
        }
        code = newCode;
        return true;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Change with correct code: " + l.changeCode("1234", "5678"));
        System.out.println("Change with wrong code: " + l.changeCode("0000", "9999"));
    }
}
