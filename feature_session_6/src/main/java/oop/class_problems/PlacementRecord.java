package oop.class_problems;

/**
 * M1. Student Placement Record Management.
 * Replaces three parallel arrays (names, companies, packages) with one
 * proper object per student.
 *
 * Expected Output (running this file's main method):
 *
 * Ravi -> TCS @ 4.5 LPA
 * Anitha -> Zoho @ 6.2 LPA
 * Karthik -> Infosys @ 4.0 LPA
 */
public class PlacementRecord {

    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {
                new PlacementRecord("Ravi", "TCS", 4.5),
                new PlacementRecord("Anitha", "Zoho", 6.2),
                new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
