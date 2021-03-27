package amit.problems.dp;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 * <p>
 * https://leetcode.com/problems/integer-break/
 *
 * Status: works
 */
public class MaxProductOfInteger {

    public static void main(String[] args) {
        MaxProductOfInteger ofInteger = new MaxProductOfInteger();
        System.out.println(ofInteger.integerBreak(10));
        System.out.println(ofInteger.integerBreak(2));
        System.out.println(ofInteger.integerBreak(4));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

}
