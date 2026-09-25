package encapsulation.class_problems;

/**
 * Problem 3 — The Nickname Tag.
 * Immutable: splits a full name once in the constructor into final
 * fields, and builds a nickname from the stored parts — nothing about
 * the name can change after creation.
 *
 * Expected Output (running this file's main method):
 *
 * Maria G.
 */
public class NameTag {

    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
