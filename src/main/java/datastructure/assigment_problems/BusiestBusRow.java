package datastructure.assigment_problems;

/**
 * Problem 10 — Busiest Bus Row.
 * Outer loop over rows, inner loop adds up the seats of that row; the best row
 * is replaced only when a total is STRICTLY larger, so a tie keeps the
 * smaller index.
 *
 * Expected Output (running this file's main method):
 * Row 1, Total 7
 *
 * Complexity: O(r * c) time, O(1) additional space.
 */
public class BusiestBusRow {

    static String busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return "Row " + bestRow + ", Total " + bestTotal;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };
        System.out.println(busiestRow(grid));
    }
}
