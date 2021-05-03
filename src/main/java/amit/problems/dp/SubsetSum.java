package amit.problems.dp;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
 */
public class SubsetSum {


    int countSubsets(int[] arr, int sum) {

        int[][] dp = new int[arr.length][sum + 1];
        for (int i = 0; i < arr.length; i++)
            dp[i][0] = 1;//Because Empty Set has sum = 0;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = arr[0] == s ? 1 : 0;
        }

        // process all subsets for all sums
        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s] + (s >= arr[i] ? dp[i - 1][s - arr[i]] : 0);
            }
        }
        return dp[arr.length - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}