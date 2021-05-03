package amit.problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

/**
 * Given an array find if you can divide the array elements into two subsets with equal sum.
 * <p>
 * e.g. [1, 3, 2] = [3] & [1, 2] both are having sum as 3 to output should be true
 * e.g. [3, 2, 2] = false it is not possible to divide this array into two subsets with equal sum.
 */
public class PartitionArray {

    public static void main(String[] args) {
        PartitionArray pa = new PartitionArray();
        test(pa::canPartitionEqually);
        test(pa::canPartitionEquallyAlternate);
        test(pa::canPartitionEquallyTabular);
    }

    private static void test(Function<int[], Boolean> func) {
        System.out.println(func.apply(new int[]{1, 2, 3}));
        System.out.println(func.apply(new int[]{1, 3, 2}));
        System.out.println(func.apply(new int[]{3, 2, 2}));
        System.out.println(func.apply(new int[]{1, 2, 3, 4}));
        System.out.println(func.apply(new int[]{1, 1, 3, 4, 7}));
        System.out.println(func.apply(new int[]{2, 3, 4, 6}));
        System.out.println();
    }

    public boolean canPartitionEqually(int[] arr) {
        int arraySum = Arrays.stream(arr).sum();

        if (arraySum % 2 != 0) { //You can divide equally if total itself is not even
            return false;
        }

        return canPartitionEqually(arr, 0, arraySum / 2, new HashMap<>());//We will find subset within this array which is one half
    }

    private boolean canPartitionEqually(int[] arr, int index, int sum, HashMap<String, Boolean> memo) {
        if (index == arr.length) {//if the numbers are going to be positive only then you can add sum < 0 check in or condition over here.
            return false;
        }
        if (sum == 0) {
            return true;
        }
        String key = index + "_" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        //Either you exclude this element in the sum or include, reduce the sum.
        boolean match = canPartitionEqually(arr, index + 1, sum, memo) || canPartitionEqually(arr, index + 1, sum - arr[index], memo);
        memo.put(key, match);
        return match;
    }

    public boolean canPartitionEquallyAlternate(int[] arr) {
        HashSet<Integer> prevSums = new HashSet<>();
        HashSet<Integer> currSums = new HashSet<>();

        prevSums.add(0);
        for (int elem : arr) {
            for (int prevSum : prevSums) {
                currSums.add(prevSum - elem);
                currSums.add(prevSum + elem);
            }
            prevSums = new HashSet<>(currSums);
            currSums.clear();
        }
        return prevSums.contains(0);
    }

    public boolean canPartitionEquallyTabular(int[] arr) {
        int arrSum = Arrays.stream(arr).sum();

        if (arrSum % 2 == 0) {
            int target = arrSum / 2;
            boolean[][] dp = new boolean[arr.length][target + 1];
            for (int i = 0; i < arr.length; i++)
                dp[i][0] = true;

            // with only one number, we can form a subset only when the required sum is equal to its value
            for (int s = 1; s <= target; s++) {
                dp[0][s] = arr[0] == s;
            }

            // process all subsets for all sums
            for (int i = 1; i < arr.length; i++) {
                for (int s = 1; s <= target; s++) {
                    // if we can get the sum 's' without the number at index 'i'
                    if (dp[i - 1][s]) {
                        dp[i][s] = dp[i - 1][s];
                    } else if (s >= arr[i]) { // else if we can find a subset to get the remaining sum
                        dp[i][s] = dp[i - 1][s - arr[i]];
                    }
                }
            }
            return dp[arr.length - 1] [target];
        }
        return false;
    }
}
