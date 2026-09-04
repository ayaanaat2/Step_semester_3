package string.class_problems;

/**
 * Fintech onboarding module — normalizes and validates transaction reference codes.
 * Format: 3 letters (bank code) + 6 digits (ddMMyy) + 5 digits (sequence number).
 */
public class BankTransactionReferenceGenerator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return firstThree + rest;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String date = reference.substring(3, 9);
        String dd = date.substring(0, 2);
        String mm = date.substring(2, 4);
        String yy = date.substring(4, 6);
        String seq = reference.substring(9, 14);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ")
              .append(dd).append("/").append(mm).append("/").append(yy)
              .append(" | SEQ: ").append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}
