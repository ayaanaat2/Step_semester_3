package oop.assigment_problems;

/**
 * M4. Exam Hall Ticket Reference Management.
 * Demonstrates that assigning an object variable to another variable
 * copies the reference, not the object — while a separately-constructed
 * object with identical field values is still a different object.
 *
 * Expected Output (running this file's main method):
 *
 * Priya's seatNumber (via first variable): 45
 * copy == priya: true
 * separate == priya: false
 */
public class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // same object, different variable name
        copy.seatNumber = 45;

        HallTicket separate = new HallTicket("Priya", 45); // a genuinely new object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
