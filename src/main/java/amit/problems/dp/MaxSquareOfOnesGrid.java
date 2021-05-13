package amit.problems.dp;

import amit.problems.arrays.ArrayUtils;

/**
 * Given a nXn matrix find the largest square which contains all '1's.
 */
public class MaxSquareOfOnesGrid {

    //Works
    public int maxSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        int maxSquareSide = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    dp[row][col] = 1;
                    if (row > 0 && col > 0) {
                        //the max square at any given cell is the min of max square at each of its previous cells (left, up and diagonal back)
                        dp[row][col] += Math.min(dp[row][col - 1], Math.min(dp[row - 1][col], dp[row - 1][col - 1]));
                        maxSquareSide = Math.max(maxSquareSide, dp[row][col]);
                    }
                }
            }
        }
        System.out.println("Input\n" + ArrayUtils.printArray2d(ArrayUtils.wrapper(grid)));
        System.out.println("DP\n" + ArrayUtils.printArray2d(ArrayUtils.wrapper(dp)));
        return maxSquareSide * maxSquareSide;
    }

    public static void main(String[] args) {
        MaxSquareOfOnesGrid maxSquareOfOnesGrid = new MaxSquareOfOnesGrid();
        System.out.println("MaxSquareArea = " + maxSquareOfOnesGrid.maxSquare(new int[][]
                {
                        {1, 0, 0, 1, 1},
                        {1, 0, 0, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 0},
                }));
    }

}
