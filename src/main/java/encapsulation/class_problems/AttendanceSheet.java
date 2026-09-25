package encapsulation.class_problems;

/**
 * Problem 5 — The Attendance Sheet.
 * Present students are stored in a private array; only a count and a
 * yes/no lookup are exposed — never the full list.
 *
 * Expected Output (running this file's main method):
 *
 * Present count: 2
 * Is Ben present: true
 * Is Chen present: false
 */
public class AttendanceSheet {

    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name) || count >= presentStudents.length) {
            return; // already marked, or sheet is full
        }
        presentStudents[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate, ignored

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present: " + sheet.isPresent("Chen"));
    }
}
