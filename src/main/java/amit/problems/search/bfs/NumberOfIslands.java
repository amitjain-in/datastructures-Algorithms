package amit.problems.search.bfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * https://leetcode.com/problems/number-of-islands
 * <p>
 * Status: working
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(
                numberOfIslands.numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }));
    }

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];//You can also use the same 'grid' and mark the lands '1' as '0' and save some space while traversing.

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    if (dfs(grid, visited, row, col, rows, cols)) {
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    public boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        boolean isIsland = true;
        visited[row][col] = true;

        //Go down
        if (row + 1 < rows && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
            isIsland = dfs(grid, visited, row + 1, col, rows, cols);
        }

        //Go right
        if (col + 1 < cols && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
            isIsland = isIsland & dfs(grid, visited, row, col + 1, rows, cols);
        }

        //Go up
        if (row > 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
            isIsland = isIsland & dfs(grid, visited, row - 1, col, rows, cols);
        }

        //Go left
        if (col > 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
            isIsland = isIsland & dfs(grid, visited, row, col - 1, rows, cols);
        }

        return isIsland;
    }
}
