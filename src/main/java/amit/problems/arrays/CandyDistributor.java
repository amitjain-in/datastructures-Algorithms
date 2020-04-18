package amit.problems.arrays;

/**
 * https://www.hackerrank.com/challenges/candies
 * This is also available in leetcode
 * There is better solution if you move from left to right and then right to left.
 */
public class CandyDistributor {

    // Complete the candies function below. Works but for very big n this times out.
    static long candiesBruteForce(int n, int[] arr) {
        int[] candies = new int[arr.length];

        candies[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = candies[i - 1] + 1;
            }
            int back = i;
            while(back - 1 >= 0 && arr[back] < arr[back - 1] && candies[back] == candies[back - 1]) {
                candies[back - 1] = candies[back - 1] + 1;
                back--;
            }
        }

        long total = 0;
        for(int candy: candies) {
            total += candy;
        }
        return total;
    }
}
