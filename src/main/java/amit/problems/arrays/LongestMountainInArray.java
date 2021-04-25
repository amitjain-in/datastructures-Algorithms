package amit.problems.arrays;

/**
 * You may recall that an array arr is a mountain array if and only if:
 *
 *     arr.length >= 3
 *     There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 *
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 */
public class LongestMountainInArray {

    public static void main(String[] args) {
        LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
        System.out.println(longestMountainInArray.longestMountain(new int[]{0, 2, 0, 2, 1, 2, 3, 4, 4, 1}));//3
        System.out.println(longestMountainInArray.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));//5
        System.out.println(longestMountainInArray.longestMountain(new int[]{2, 2, 2}));//0
        System.out.println(longestMountainInArray.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));//5
        System.out.println(longestMountainInArray.longestMountain(new int[]{3, 3, 1}));//5
        System.out.println(longestMountainInArray.longestMountain(new int[]{1, 1, 0, 0, 1, 0}));//3
    }

    //Status works
    public int longestMountain(int[] arr) {
        int max = 0;

        int increaseStart = Integer.MAX_VALUE;
        boolean increase = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1] && !increase) {
                increaseStart = i - 1;
                increase = true;
            }
            if (arr[i] == arr[i - 1]) {
                increaseStart = Integer.MAX_VALUE;
                increase = false;
            }

            if (arr[i] < arr[i - 1]) {
                increase = false;
                max = Math.max(max, i - increaseStart + 1);
            }
        }

        return max;
    }
}
