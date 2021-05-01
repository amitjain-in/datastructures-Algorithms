package amit.problems.dp;

/**
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 */
public class UniquePathsWithObstacles {

    //Status: Works
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int col = 1; col < n; col++) {
            dp[0][col] = obstacleGrid[0][col] == 0 && dp[0][col - 1] == 1 ? 1 : 0;
        }

        for (int row = 1; row < m; row++) {
            dp[row][0] = obstacleGrid[row][0] == 0 && dp[row - 1][0] == 1 ? 1 : 0;
            for (int col = 1; col < n; col++) {
                if (obstacleGrid[row][col] == 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
