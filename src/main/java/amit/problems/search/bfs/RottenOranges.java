package amit.problems.search.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottenOranges {

    public static void main(String[] args) {

    }

    //Status: works
    public int orangesRotting(int[][] grid) {

        boolean process = true;
        int rows = grid.length;
        int cols = grid[0].length;

        int mins = 0;
        List<Point> orangesToRot = new LinkedList<>();
        boolean containsFresh = false;

        while (process) {
            process = false;
            mins++;
            containsFresh = false;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col] == 2) {
                        if (row > 0 && grid[row - 1][col] == 1) {
                            orangesToRot.add(new Point(row - 1, col));
                        }
                        if (col > 0 && grid[row][col - 1] == 1) {
                            orangesToRot.add(new Point(row, col - 1));
                        }
                        if (row + 1 < rows && grid[row + 1][col] == 1) {
                            orangesToRot.add(new Point(row + 1, col));
                        }
                        if (col + 1 < cols && grid[row][col + 1] == 1) {
                            orangesToRot.add(new Point(row, col + 1));
                        }
                    } else if(grid[row][col] == 1) {
                        containsFresh = true;
                    }
                }
            }
            if (!orangesToRot.isEmpty()) {
                process = true;
                for (Point p : orangesToRot) {
                    grid[p.row][p.col] = 2;
                }
                orangesToRot.clear();
            } else {
                if(containsFresh) {
                    return -1;
                }
            }
        }
        return mins - 1;
    }

    static class Point {
        final int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
