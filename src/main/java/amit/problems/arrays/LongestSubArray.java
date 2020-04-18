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

        int[] maxLengthArray = new int[arr.length];
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++) {
            maxLengthArray[i] = 1;
            int sum = 0;
            int length = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
            }
        }
        return maxLengthArray;
    }
}
