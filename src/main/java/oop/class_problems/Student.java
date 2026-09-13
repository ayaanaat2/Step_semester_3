package oop.class_problems;

/**
 * M5. Student and College Information Management.
 * Moves the college name out of every instance and into one shared
 * static field, alongside a static counter incremented per construction.
 *
 * Expected Output (running this file's main method):
 *
 * SRM Institute of Science and Technology
 * Students created: 2
 */
public class Student {

    private String name;
    private int attendance;

    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Ravi", 92);
        new Student("Anitha", 88);

        Student.printCollegeInfo();
    }
}
