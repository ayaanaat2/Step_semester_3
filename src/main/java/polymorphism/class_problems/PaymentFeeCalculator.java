package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1 — Payment System Fee Calculation.
 * Each payment type overrides finalAmount(); the main loop treats every
 * transaction uniformly through the Payment base type (no if-else on type).
 *
 * Sample Input:
 * 3
 * CARD 1000
 * WALLET 500
 * BANKTRANSFER 2000
 *
 * Expected Output:
 * CARD: 1020.00
 * WALLET: 505.00
 * BANKTRANSFER: 2000.00
 * Total: 3525.00
 */
public class PaymentFeeCalculator {

    static abstract class Payment {
        protected final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        String type() { return "CARD"; }
        double finalAmount() { return amount + amount * 0.02; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        String type() { return "WALLET"; }
        double finalAmount() { return amount + amount * 0.01; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        String type() { return "BANKTRANSFER"; }
        double finalAmount() { return amount; }
    }

    static Payment create(String type, double amount) {
        return switch (type) {
            case "CARD" -> new CardPayment(amount);
            case "WALLET" -> new WalletPayment(amount);
            case "BANKTRANSFER" -> new BankTransferPayment(amount);
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(create(type, amount));
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", p.type(), adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
