package amit.problems.arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class StockBuySell {

    public static void main(String[] args) {
        StockBuySell stockBuySell = new StockBuySell();
        System.out.println(stockBuySell.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(stockBuySell.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(stockBuySell.maxProfit(new int[]{1, 5}));
    }

    //Working
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        //Since you only buy and sell once during entire period, so this is simple.
        for (int price : prices) {
            buyPrice = Math.min(buyPrice, price);
            profit = Math.max(profit, price - buyPrice);
        }

        return profit;
    }
}
