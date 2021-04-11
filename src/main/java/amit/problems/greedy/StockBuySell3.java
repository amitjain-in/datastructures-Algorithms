package amit.problems.greedy;


/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class StockBuySell3 {

    public static void main(String[] args) {
        StockBuySell3 stockBuySell3 = new StockBuySell3();
        System.out.println(stockBuySell3.maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));//13 //Fails as 1-7 = 6 + 2-9 =7 so it should 6 + 7
        System.out.println(stockBuySell3.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));//6
        System.out.println(stockBuySell3.maxProfit(new int[]{1, 2, 3, 4, 5}));//4
        System.out.println(stockBuySell3.maxProfit(new int[]{7, 6, 4, 3, 1}));//0
        System.out.println(stockBuySell3.maxProfit(new int[]{1}));//0
        System.out.println(stockBuySell3.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));//7

    }

    //Not working
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length + 1];
        dp[0][0] = 0;

        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    dp[k][i] = Math.max(dp[k][i - 1], prices[i] - prices[j] + dp[k - 1][j - 1]);
                }
            }
        }
        return dp[1][prices.length];
    }
}
