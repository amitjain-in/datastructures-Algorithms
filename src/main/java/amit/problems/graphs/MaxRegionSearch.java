package amit.problems.graphs;

/**
 * Consider a matrix where each cell contains either a 0 or 1 is called a <em>filled</em> cell. Two cells are said to be <em>connected</em> if they are adjacent to each other horizontally, vertically, or diagonally.
 * In the diagram below, the two colored regions show cells connected to the filled cells. Black on white are not connected.
 * If one or more filled cells are also connected, they form a <em>region</em>.
 * Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.
 * In the diagram below, the two colors represent two different regions.
 */

public class MaxRegionSearch {

    //Below solution works - All test cases cleared.
    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int maxRegionSize = 0;
        int currRegionSize = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == 1) {
                        currRegionSize += dfs(grid, visited, i, j);
                        if (currRegionSize > maxRegionSize) {
                            maxRegionSize = currRegionSize;
                        }
                    } else {
                        visited[i][j] = true;
                    }
                }
                currRegionSize = 0;
            }
        }
        return maxRegionSize;
    }

    static int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int more = !visited[row][col] ? grid[row][col] : 0;
        if (visited[row][col] || more == 0) {
            return more;
        }
        visited[row][col] = true;
        if (col + 1 < grid[0].length) {//Side
            if (!visited[row][col + 1]) {
                more += dfs(grid, visited, row, col + 1);
            }
        }//Bottom
        if (row + 1 < grid.length) {
            if (col + 1 < grid[0].length) {
                if (!visited[row + 1][col + 1]) {
                    more += dfs(grid, visited, row + 1, col + 1);
                }
            }
            if (!visited[row + 1][col]) {
                more += dfs(grid, visited, row + 1, col);
            }
            if (col - 1 >= 0) {
                if (!visited[row + 1][col - 1]) {
                    more += dfs(grid, visited, row + 1, col - 1);
                }
            }
        }

        //Top
        if (row - 1 >= 0) {
            if (col - 1 >= 0 && !visited[row - 1][col - 1]) {
                more += dfs(grid, visited, row - 1, col - 1);
            }
            if (!visited[row - 1][col]) {
                more += dfs(grid, visited, row - 1, col);
            }
            if (col + 1 < grid[0].length && !visited[row - 1][col + 1]) {
                more += dfs(grid, visited, row - 1, col + 1);
            }
        }
        return more;
    }
}
