package amit.problems.recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents.
 *
 * If the given number of denominations are fixed then there can be cleaner solution.
 * But we have written a more generic one and it returns the coin combinations too and not just the number of combinations.
 */
public class CoinCombinations {

    public static void main(String[] args) {
        printCoin(combinationsOfCoin(new int[]{25, 5, 1}, 25));
        printCoin(combinationsOfCoin(new int[]{25, 5, 1}, 37));
    }

    private static void printCoin(List<List<CoinCombination>> combs) {
        for (List<CoinCombination> comb : combs) {
            for (CoinCombination coinCombination : comb) {
                System.out.print(coinCombination + ", ");
            }
            System.out.println();
        }
        System.out.println("************");
    }

    private static Map<Integer, List<List<CoinCombination>>> dp = new HashMap<>();

    private static List<List<CoinCombination>> combinationsOfCoin(int[] coins, int n) {
        return dp.computeIfAbsent(n, (n1) -> {
            int coin = coins[0];
            List<List<CoinCombination>> combinations = new LinkedList<>();
            int remaining = n;
            for (int counter = 1; remaining > 0; counter++) {
                remaining = n - coin * counter;
                boolean coinUsed = false;
                if (remaining > 0) {//The coin fits the number
                    coinUsed = true;
                }
                if (remaining != 0) {
                    if (coins.length > 1) {
                        int[] remainingCoins = new int[coins.length - 1];
                        System.arraycopy(coins, 1, remainingCoins, 0, coins.length - 1);
                        List<List<CoinCombination>> childCombinations = combinationsOfCoin(remainingCoins, coinUsed ? remaining : n);
                        if (coinUsed) {
                            for (List<CoinCombination> coinC : childCombinations) {
                                CoinCombination coinCombination = new CoinCombination(coin, counter);
                                coinC.add(coinCombination);
                                combinations.add(coinC);
                            }
                        } else {
                            combinations.addAll(childCombinations);
                        }
                    }
                } else {
                    //Nothing else remaining to fit
                    List<CoinCombination> list = new LinkedList<>();
                    list.add(new CoinCombination(coin, counter));
                    combinations.add(list);
                }
            }
            return combinations;
        });
    }

    static class CoinCombination {
        private final int coin;
        private final int coinCounter;

        public CoinCombination(int coin, int coinCounter) {
            this.coin = coin;
            this.coinCounter = coinCounter;
        }

        public int getCoin() {
            return coin;
        }

        public int getCoinCounter() {
            return coinCounter;
        }

        @Override
        public String toString() {
            return coin + " X " + coinCounter;
        }
    }
}
