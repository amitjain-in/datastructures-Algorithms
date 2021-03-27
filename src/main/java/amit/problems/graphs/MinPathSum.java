package amit.problems.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
//        System.out.println(minPathSum.minPathSum(new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        }));
//
//        System.out.println(minPathSum.minPathSum(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6}
//        }));

        System.out.println(minPathSum.minPathSum(new int[][]{
                {7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5},
                {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6},
                {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8},
                {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4},
                {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4},
                {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9},
                {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4},
                {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2},
                {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3},
                {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7},
                {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7},
                {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}
        }));
    }

    public int minPathSum(int[][] grid) {
        int[][] distances = new int[grid.length][grid[0].length];
        int row = grid.length;
        while (--row >= 0) {
            Arrays.fill(distances[row], Integer.MAX_VALUE);
        }
        distances[0][0] = grid[0][0];
        int[][] visited = new int[grid.length][grid[0].length];
        djikstraWithQueue(grid, distances, visited);
        return distances[grid.length - 1][grid[0].length - 1];
    }

    //Works but is too slow for large matrix due to repeated calls.
    public void djikstra(int[][] grid, int[][] distances, boolean[][] visited, int row, int col) {

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return;
        }

        visited[row][col] = true;
        if (col + 1 < grid[0].length)
            distances[row][col + 1] = Math.min(distances[row][col + 1], distances[row][col] + grid[row][col + 1]);

        if (row + 1 < grid.length)
            distances[row + 1][col] = Math.min(distances[row + 1][col], distances[row][col] + grid[row + 1][col]);

        if (row + 1 < grid.length) {
            djikstra(grid, distances, visited, row + 1, col);
        }

        if (col + 1 < grid[0].length) {
            djikstra(grid, distances, visited, row, col + 1);
        }
    }

    //There is a faster solution than below using bottom-up DP approach with memoization.
    public void djikstraWithQueue(int[][] grid, int[][] distances, int[][] visited) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {

            Point p = q.remove();
            System.out.println("row = " + p.row + " col =" + p.col);

            visited[p.row][p.col] = Point.VISITED;

            if (p.col + 1 < grid[0].length) {
                distances[p.row][p.col + 1] = Math.min(distances[p.row][p.col + 1], distances[p.row][p.col] + grid[p.row][p.col + 1]);
                if (visited[p.row][p.col + 1] == Point.NOT_ADDED) {
                    visited[p.row][p.col + 1] = Point.ADDED;
                    q.add(new Point(p.row, p.col + 1));
                }
            }

            if (p.row + 1 < grid.length) {
                distances[p.row + 1][p.col] = Math.min(distances[p.row + 1][p.col], distances[p.row][p.col] + grid[p.row + 1][p.col]);
                if (visited[p.row + 1][p.col] == Point.NOT_ADDED) {
                    visited[p.row + 1][p.col] = Point.ADDED;
                    q.add(new Point(p.row + 1, p.col));
                }
            }

        }
    }

    static class Point {

        static final int NOT_ADDED = 0;
        static final int ADDED = 2;
        static final int VISITED = 2;

        final int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
