package amit.problems.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * https://leetcode.com/problems/coin-change/
 *
 */
public class CoinChange {

    //Status: works
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return coinChange(coins, amount, dp);
    }

    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -2) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int newMin = 1 + coinChange(coins, amount - coin, dp);
                if (newMin != 0) {
                    min = Math.min(min, newMin);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            dp[amount] = -1;
        } else {
            dp[amount] = min;
        }
        //System.out.println("Amt: " + amount + " - " + dp[amount]);
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        // System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(cc.coinChange(new int[]{2}, 3));
    }

}
