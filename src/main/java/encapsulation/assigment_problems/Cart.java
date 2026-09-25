package encapsulation.assigment_problems;

/**
 * Problem 5 — The Shopping Cart.
 * Prices are stored in a private array; only the total and item count
 * are exposed, both computed on request rather than stored separately.
 *
 * Expected Output (running this file's main method):
 *
 * Total: 500.0
 * Item count: 3
 */
public class Cart {

    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    public void addItem(double price) {
        if (count >= prices.length) {
            return; // cart full
        }
        prices[count] = price;
        count++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
