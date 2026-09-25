package encapsulation.assigment_problems;

/**
 * Problem 1 — The Health Bar.
 * Health is private, changed only through takeDamage()/heal(), and is
 * always clamped between 0 and the final maxHealth.
 *
 * Expected Output (running this file's main method):
 *
 * After takeDamage(30): 70
 * After heal(50): 100
 * After takeDamage(150): 0
 */
public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After takeDamage(30): " + c.getHealth());
        c.heal(50);
        System.out.println("After heal(50): " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After takeDamage(150): " + c.getHealth());
    }
}
