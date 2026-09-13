package oop.assigment_problems;

/**
 * M1. Library Inventory Management.
 * Replaces three parallel arrays (titles, authors, copiesAvailable) with
 * one proper object per book.
 *
 * Expected Output (running this file's main method):
 *
 * Clean Code by Robert C. Martin - 3 copies available
 * Effective Java by Joshua Bloch - 5 copies available
 * Refactoring by Martin Fowler - 0 copies available
 * Design Patterns by GoF - 2 copies available
 */
public class BookInventory {

    private String title;
    private String author;
    private int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        BookInventory[] books = {
                new BookInventory("Clean Code", "Robert C. Martin", 3),
                new BookInventory("Effective Java", "Joshua Bloch", 5),
                new BookInventory("Refactoring", "Martin Fowler", 0),
                new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}
