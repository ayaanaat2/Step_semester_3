package array.class_problems;

import java.util.Arrays;

/**
 * L5. Rotate Array — rotates an array to the right by k positions.
 */
public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[(i + k) % length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
    }
}
