package amit.problems.dp;


/**
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * <p>
 * https://leetcode.com/problems/ones-and-zeroes/
 */
public class OnesAndZeroes {

    public static void main(String[] args) {
        OnesAndZeroes os = new OnesAndZeroes();
        System.out.println(os.findMaxForm(new String[] {"0", "1", "100001", "11", "10"}, 3, 4));//4
        System.out.println(os.findMaxForm(new String[] {"0", "1", "100001", "11", "10"}, 5, 3));//3
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = getOnesAndZeroes(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    public int[] getOnesAndZeroes(String strs) {

        int[] count = new int[2];

        for (char c : strs.toCharArray()) {
            switch (c) {
                case '0':
                    count[0]++;
                    break;

                case '1':
                    count[1]++;
                    break;
            }
        }
        return count;
    }
}