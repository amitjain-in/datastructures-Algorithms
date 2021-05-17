package amit.problems.dp;

public class MaxNonNegativeProduct {

    //doesn't work when there is actual 0 in the elements of the matrix and it is required in the final path of solution.
    //So the final condition when returning needs to be changed.
    public int maxProductPath(int[][] grid) {

        int[][][] dp = new int[grid.length][grid[0].length][2];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] < 0) {
                    if (row > 0 && col > 0) {
                        dp[row][col][0] = modMultiple(Math.min(dp[row][col - 1][1], dp[row - 1][col][1]), grid[row][col]);
                        dp[row][col][1] = modMultiple(Math.max(dp[row][col - 1][0], dp[row - 1][col][0]), grid[row][col]);
                    } else if (row > 0) {
                        dp[row][col][0] = modMultiple(dp[row - 1][col][1], grid[row][col]);
                        dp[row][col][1] = modMultiple(dp[row - 1][col][0], grid[row][col]);
                    } else if (col > 0) {
                        dp[row][col][0] = modMultiple(dp[row][col - 1][1], grid[row][col]);
                        dp[row][col][1] = modMultiple(dp[row][col - 1][0], grid[row][col]);
                    } else {
                        dp[row][col][1] = grid[row][col];
                    }
                } else {
                    if (row > 0 && col > 0) {
                        dp[row][col][0] = modMultiple(Math.max(dp[row][col - 1][0], dp[row - 1][col][0]), grid[row][col]);
                        dp[row][col][1] = modMultiple(Math.min(dp[row][col - 1][1], dp[row - 1][col][1]), grid[row][col]);
                    } else if (row > 0) {
                        dp[row][col][0] = modMultiple(dp[row - 1][col][0], grid[row][col]);
                        dp[row][col][1] = modMultiple(dp[row - 1][col][1], grid[row][col]);
                    } else if (col > 0) {
                        dp[row][col][0] = modMultiple(dp[row][col - 1][0], grid[row][col]);
                        dp[row][col][1] = modMultiple(dp[row][col - 1][1], grid[row][col]);
                    } else {
                        dp[row][col][0] = grid[row][col];
                    }
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1][0] > 0 ? dp[grid.length - 1][grid[0].length - 1][0] : -1;
    }

    private int modMultiple(int a, int b) {
        return (int) (((long) a * b) % 1_000_0000_007L);
    }

    public static void main(String[] args) {
        MaxNonNegativeProduct maxNonNegativeProduct = new MaxNonNegativeProduct();
        System.out.println(maxNonNegativeProduct.maxProductPath(new int[][]{
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        }));

        System.out.println(maxNonNegativeProduct.maxProductPath(new int[][]{
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        }));
    }
}
