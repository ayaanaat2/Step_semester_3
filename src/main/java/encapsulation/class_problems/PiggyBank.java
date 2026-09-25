package encapsulation.class_problems;

/**
 * Problem 1 — The Piggy Bank.
 * Savings can only change through deposit/withdraw — never set directly.
 * A withdrawal larger than the current savings is rejected outright.
 *
 * Expected Output (running this file's main method):
 *
 * After deposit: 100.0
 * After withdraw: 70.0
 * After rejected withdraw: 70.0
 */
public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            return; // rejected, savings stays unchanged
        }
        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("After rejected withdraw: " + pb.getSavings());
    }
}
