package amit.problems.dp;


/**
 * Imagine you have infinite supply of coins of certain denominations given in an array and you are given a value n.
 * Find out how many unique ways can make the number n from the coins supply.
 */
public class CoinChangeWays {

    public static void main(String[] args) {
        System.out.println(coinChangeWays(new int[]{1, 2}, 4));//[(1 1 1 1), (1 1 2), (2 2)]
        System.out.println(coinChangeWays(new int[]{1, 2, 3}, 4));//[(1 1 1 1), (1 1 2), (2 2), (3, 1)]
        System.out.println(coinChangeWays(new int[]{1, 2}, 7));//[(1 1 1 1 1 1 1), (2 2 2 1), (2 1 1 1 2) (2 1 1 1 1 1)]
        System.out.println(coinChangeWays(new int[]{1, 2, 3}, 100));//884 (trust induction)
    }

    //O(m * n)
    public static int coinChangeWays(int[] coins, int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                arr[i] += arr[i - coin];
            }
        }
        return arr[n];
    }
}
