package amit.problems.search.bfs;

import amit.problems.arrays.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 * <p>
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * <p>
 * You must assign each cell a height in a way that follows these rules:
 * <p>
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1.
 * A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
 * <p>
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 * <p>
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
 * <p>
 * https://leetcode.com/problems/map-of-highest-peak/
 */
public class MapHighestPeak {

    //Status works
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] heights = new int[rows][cols];

        Queue<Cell> bfs = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col] == 1) {
                    bfs.add(new Cell(row, col));
                }
            }
        }
        int[][] bfsIndices = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!bfs.isEmpty()) {
            Cell cell = bfs.poll();
            for (int[] bfsIndex : bfsIndices) {
                if ((isBound(cell.row + bfsIndex[0], cell.col + bfsIndex[1], rows, cols, isWater, heights))) {
                    heights[cell.row + bfsIndex[0]][cell.col + bfsIndex[1]] = heights[cell.row][cell.col] + 1;
                    bfs.add(new Cell(cell.row + bfsIndex[0], cell.col + +bfsIndex[1]));
                }
            }
        }

        return heights;
    }


    private boolean isBound(int row, int col, int rows, int cols, int[][] isWater, int[][] result) {
        return row >= 0 && col >= 0 && row < rows && col < cols && isWater[row][col] != 1 && result[row][col] == 0;
    }

    private static class Cell {
        final int row, col;

        public Cell(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    public static void main(String[] args) {
        MapHighestPeak mapHighestPeak = new MapHighestPeak();
        System.out.println(ArrayUtils.printArray2d(ArrayUtils.wrapper(mapHighestPeak.highestPeak(new int[][]{
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        }))));//[1, 1, 0], [0, 1, 1], [1, 2, 2]

        System.out.println(ArrayUtils.printArray2d(ArrayUtils.wrapper(mapHighestPeak.highestPeak(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        }))));//[0, 1, 2], [1, 2, 1], [2, 1, 0]
    }
}
