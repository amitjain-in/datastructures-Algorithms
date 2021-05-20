package amit.problems.dp;

import java.util.Arrays;

/**
 * Find the maximum (in length) increasing subsequence (include non-contiguous elements too in sub-array consideration).
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestIncreasingSubArray(new int[]{6, 2, 5, 1, 7, 4, 8, 3})));//2, 5, 7, 8
    }

    /**
     * If there are more than one sub array of the same max length the it prints only the first one.
     *
     * @param arr - The input array
     * @return - The longest increasing sub-array which could be non-contiguous
     */
    public static int[] longestIncreasingSubArray(int[] arr) {
        int[] maxIdx = new int[arr.length];
        int maxEnd = 0;
        int maxLength = 0;

        //We calculate the max sub arrays values for initial index and then use the same values to find max values of further indexes.
        for (int i = 0; i < arr.length; i++) {
            maxIdx[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxIdx[i] = Math.max(maxIdx[i], maxIdx[j] + 1);
                    if (maxLength < maxIdx[i]) {
                        maxLength = maxIdx[i];
                        maxEnd = i;
                    }
                }
            }
        }

        int[] result = new int[maxLength];

        //Trace back the array to find the final Max length Sub-Array
        for (int i = maxEnd; i >= 0; i--) {
            if (maxLength == maxIdx[i]) {
                result[--maxLength] = arr[i];
            }
        }
        return result;
    }
}
