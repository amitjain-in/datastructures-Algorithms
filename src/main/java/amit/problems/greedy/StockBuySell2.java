package amit.problems.greedy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class StockBuySell2 {

    public static void main(String[] args) {
        StockBuySell2 stockBuySell2 = new StockBuySell2();
        System.out.println(stockBuySell2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));//7
        System.out.println(stockBuySell2.maxProfit(new int[]{1, 2, 3, 4, 5}));//4
        System.out.println(stockBuySell2.maxProfit(new int[]{7, 6, 4, 3, 1}));//0
    }


    //Status: Works
    public int maxProfit(int[] prices) {
        int buyPrice = -1;//The testcases have some scenarios with 0 prices. Hence marking it as -1
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice == -1) {
                if ((i + 1 < prices.length && prices[i] < prices[i + 1])) {
                    buyPrice = prices[i];
                }
            } else {
                if ((i + 1 == prices.length || (prices[i + 1] < prices[i])) && buyPrice < prices[i]) {
                    profit += prices[i] - buyPrice;
                    buyPrice = -1;
                }
            }
        }
        return profit;
    }
}
