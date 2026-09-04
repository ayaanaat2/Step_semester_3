package array.class_problems;

/**
 * L2. Best Time to Buy and Sell Stock — max profit from a single buy/sell.
 */
public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profitIfSoldToday);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
