package amit.problems.dp;

/**
 * Delete at most one element from an array and find the max contiguous sub-array with at least one element.
 */
public class MaxSumWithOneDelete {

    public static void main(String[] args) {
        MaxSumWithOneDelete maxSumWithOneDelete = new MaxSumWithOneDelete();

        System.out.println(maxSumWithOneDelete.maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(maxSumWithOneDelete.maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(maxSumWithOneDelete.maximumSum(new int[]{-1, -1, -1, -1}));
    }

    public int maximumSum(int[] arr) {

        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);//Normal max sub array sum without deletion
            dp[i][1] = Math.max(arr[i], Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]));
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        return max;
    }
}
