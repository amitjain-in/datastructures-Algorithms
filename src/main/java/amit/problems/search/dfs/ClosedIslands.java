package amit.problems.search.dfs;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * https://leetcode.com/problems/number-of-closed-islands
 * <p>
 * Status: Working
 */
public class ClosedIslands {


    public static void main(String[] args) {
        ClosedIslands closedIslands = new ClosedIslands();

        //y
        System.out.println(closedIslands.closedIsland(new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}

        }));

        //4
        System.out.println(closedIslands.closedIsland(new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 1, 0}
        }));

        //1
        System.out.println(closedIslands.closedIsland(new int[][]{
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0}
        }));
    }


    public int closedIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int closedIslands = 0;

        for (int row = 1; row < rows - 1; row++) {

            for (int col = 1; col < cols - 1; col++) {
                if (!visited[row][col] && grid[row][col] == 0) {
                    if (dfs(grid, visited, row, col, rows, cols)) {
                        closedIslands++;
                    }
                }
            }
        }

        return closedIslands;
    }

    public boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        boolean isIsland = true;
        visited[row][col] = true;

        if (row == 0 || col == 0) {//Top and left edge
            isIsland = grid[row][col] == 1;
        }

        if (row + 1 == rows || col + 1 == cols) {//bottom and right edge
            isIsland = isIsland & grid[row][col] == 1;
        }

        if (!isIsland) {
            return false;
        }

        if (row < rows && grid[row + 1][col] == 0 && !visited[row + 1][col]) {
            isIsland = dfs(grid, visited, row + 1, col, rows, cols);
        }

        if (col < cols && grid[row][col + 1] == 0 && !visited[row][col + 1]) {
            isIsland = isIsland & dfs(grid, visited, row, col + 1, rows, cols);
        }

        if (row > 0 && grid[row - 1][col] == 0 && !visited[row - 1][col]) {
            isIsland = isIsland & dfs(grid, visited, row - 1, col, rows, cols);
        }

        if (col > 0 && grid[row][col - 1] == 0 && !visited[row][col - 1]) {
            isIsland = isIsland & dfs(grid, visited, row, col - 1, rows, cols);
        }

        return isIsland;
    }
}
