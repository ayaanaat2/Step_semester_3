package oop.class_problems;

/**
 * M2. Hostel Mess Wallet Management.
 * Encapsulates balance behind topUp/deduct/getBalance so it can never go
 * negative or be overwritten directly from outside the class.
 *
 * Expected Output (running this file's main method):
 *
 * Balance after top-up: 700.0
 * Deduct rejected: insufficient balance
 * Final balance: 700.0
 */
public class MessWallet {

    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance given, starting at 0.0 instead.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
