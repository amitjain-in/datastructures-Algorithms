package amit.problems.arrays;

import java.util.Arrays;

/**
 * Given an array and an integer K, find the length of longest sub-array that has sum less than or equal to K.
 * //Not working
 */
public class LongestSubArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLongestSubArray(new int[]{0, 1, 2, 3, 5}, 3)));
    }

    private static int[] findLongestSubArray(int[] arr, int k) {
        int maxStartIdx = 0;
        int maxEndIdx = 0;
        int maxSum = arr[0];
        int currStartIdx = 0;
        int currEndIdx = 0;
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxSum <= currentSum + arr[i]) {
                currentSum += arr[i];
                maxSum = currentSum;
                currEndIdx = i;
                maxStartIdx = currStartIdx;
                maxEndIdx = currEndIdx;
            } else if (currentSum <= currentSum + arr[i]) {
                currentSum += arr[i];
                currEndIdx = i;
            } else {
                currStartIdx = i + 1;
                currEndIdx = i + 1;
            }
        }
        int[] returnArr = new int[maxEndIdx - maxStartIdx];
        System.arraycopy(arr, maxStartIdx, returnArr, 0, maxEndIdx - maxStartIdx);
        return returnArr;
    }
}
