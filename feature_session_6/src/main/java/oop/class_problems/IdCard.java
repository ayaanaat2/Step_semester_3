package oop.class_problems;

/**
 * M4. Library ID Card Management.
 * Demonstrates that assigning an object variable to another variable
 * copies the reference, not the object — while a separately-constructed
 * object with identical field values is still a different object.
 *
 * Expected Output (running this file's main method):
 *
 * Ravi's booksIssued (via first variable): 3
 * duplicate == ravi: true
 * separate == ravi: false
 */
public class IdCard {

    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // same object, different variable name
        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // a genuinely new object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
