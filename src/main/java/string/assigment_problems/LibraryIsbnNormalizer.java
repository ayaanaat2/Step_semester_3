package string.assigment_problems;

/**
 * Library intake scanner — normalizes and validates ISBN-style codes.
 * Format: 3 letters (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class LibraryIsbnNormalizer {

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return firstThree + rest;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();
        result.append("[").append(publisherCode).append("] YEAR: ")
              .append(year).append(" | CATALOG: ").append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));
    }
}
