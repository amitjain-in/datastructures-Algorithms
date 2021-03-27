package amit.problems.dp;

/**
 * Given an array of integers, find the subset of the non-adjacent elements with the maximum sum.
 * Calculate the sum of that subset.
 * arr = [-2, 1, 3, -4, 5]
 * output of [3, 5] is 8
 */
public class MaxSubsetSum {

    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        if(arr.length > 1) {
            //Because of non-contiguous elements constraint, the max will never be arr[0] + arr[1].
            dp[1] = Math.max(arr[0], arr[1]);
            max = dp[1];
        }

        for(int i = 2; i < arr.length; i++) {
            //Since this sum of non-contiguous elements, the max at any given index will either max at previous index or sum of max of two index down and current element
            dp[i] = Math.max(Math.max(arr[i], dp[i - 1]), dp[i - 2] + arr[i]);
            if(dp[i] > max)  {
                max = dp[i];
            }
        }
        return max;
    }

}
