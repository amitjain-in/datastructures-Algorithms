package amit.problems.twopointers;

import java.util.Arrays;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 */
public class PairWithTargetSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(search(new int[]{2, 5, 9, 11}, 11)));
    }

    public static int[] search(int[] arr, int targetSum) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == targetSum) {
                return new int[]{start, end};
            } else if (sum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }
}
