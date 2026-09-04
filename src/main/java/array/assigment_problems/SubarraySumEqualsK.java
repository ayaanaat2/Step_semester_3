package array.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * A4. Subarray Sum Equals K — prefix sums + hash map of frequencies.
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1); // empty prefix

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            count += prefixSumCounts.getOrDefault(currentSum - k, 0);
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
