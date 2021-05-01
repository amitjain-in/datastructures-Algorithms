package amit.problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 *
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    //Status: works
    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new HashMap<>());
    }

    public int uniquePaths(int m, int n, Map<String, Integer> memo) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }
        String key = m + "_ " + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int paths = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo); //Go down and Go right
        memo.put(key, paths);
        return paths;
    }

    //Status: Works
    public int uniquePathsTabular(int m, int n) {

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int row = 1; row < m; row++) {
            dp[row][0] = 1;
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][ n -1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();

        System.out.println(up.uniquePaths(3, 7));
        System.out.println(up.uniquePathsTabular(3, 7));
    }

}
