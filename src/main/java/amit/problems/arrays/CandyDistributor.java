package amit.problems.arrays;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/candies
 * This is also available in leetcode
 */
public class CandyDistributor {

    // Complete the candies function below. Works but for very big n this times out.
    static long candiesBruteForce(int n, int[] arr) {
        int[] candies = new int[arr.length];

        candies[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = candies[i - 1] + 1;
            }
            int back = i;
            while (back - 1 >= 0 && arr[back] < arr[back - 1] && candies[back] == candies[back - 1]) {
                candies[back - 1] = candies[back - 1] + 1;
                back--;
            }
        }

        long total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

    /**
     * This solutions works and is 94% faster than other Java submissions at leetcode.
     * <p>
     * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
     * All the children sit in a line and each of them has a rating score according to his or her performance in the class.
     * Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies.
     * Alice wants to minimize the total number of candies she must buy.
     * <p>
     * <p>
     * e.g. if input is [4 6 4 5 6 2] then she must be give following candies [1, 2, 1, 2, 3, 1] . She must buy a minimum of 10 candies.
     *
     * @param arr their ranking
     * @return min number of candies required for distribution
     */
    static long candiesNew(int[] arr) {

        System.out.println("Input: " + Arrays.toString(arr));
        int[] candies = new int[arr.length];
        long totalCandies = 0;

        candies[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1] && candies[i] <= candies[i + 1]) {
                candies[i] = Math.max(candies[i] + 1, candies[i + 1] + 1);
            }
        }
        for (int candy : candies) {
            totalCandies += candy;
        }
        System.out.println("Output: " + Arrays.toString(candies) + ", Total = " + totalCandies + "\n");

        return totalCandies;
    }
}
