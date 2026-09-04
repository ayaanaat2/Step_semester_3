package string.class_problems;

/**
 * Assignment-upload portal — checks whether a filename has an accepted extension.
 */
public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (accepted.equalsIgnoreCase(extension)) {
                return "Accepted";
            }
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
