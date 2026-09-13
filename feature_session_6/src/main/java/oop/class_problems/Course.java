package oop.class_problems;

/**
 * M3. Course Credit Management.
 * Supports theory-only courses without duplicating setup logic, by
 * chaining a 3-arg constructor to the 4-arg one via this(...).
 *
 * Expected Output (running this file's main method):
 *
 * 21CSC201J total credits: 4
 * 21CSC205L total credits: 4
 */
public class Course {

    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Course theoryOnly = new Course("21CSC201J", "Data Structures", 4);
        Course withLab = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryOnly.code + " total credits: " + theoryOnly.totalCredits());
        System.out.println(withLab.code + " total credits: " + withLab.totalCredits());
    }
}
