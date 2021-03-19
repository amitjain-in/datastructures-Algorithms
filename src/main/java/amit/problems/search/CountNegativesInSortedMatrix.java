package amit.problems.search;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix
 * Level - Easy
 * Status - Passed
 */
public class CountNegativesInSortedMatrix {

    public static void main(String[] args) {

        CountNegativesInSortedMatrix countNegativesInSortedMatrix = new CountNegativesInSortedMatrix();
        System.out.println(countNegativesInSortedMatrix.countNegatives(new int[][]{
                {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}
        }));

        System.out.println(countNegativesInSortedMatrix.countNegatives(new int[][]{
                {3, -1}, {1, -1}
        }));
    }

    public int countNegatives(int[][] grid) {
        int totalNegatives = 0;
        for (int row = 0; row < grid.length; row++) {
            int negIdx = findFirstNegative(grid, row, 0, grid[0].length - 1);
            if (negIdx >= 0) {
                totalNegatives += grid[0].length - negIdx;
            }
        }

        return totalNegatives;
    }

    public static int findFirstNegative(int[][] grid, int row, int left, int right) {
        if (left > right) {
            return -1;
        }
        int midIdx = left + (right - left) / 2;
        if (grid[row][midIdx] < 0 && (midIdx == 0 || grid[row][midIdx - 1] >= 0)) {
            return midIdx;
        } else if (grid[row][midIdx] < 0) {
            return findFirstNegative(grid, row, left, midIdx - 1);
        } else {
            return findFirstNegative(grid, row, midIdx + 1, right);
        }
    }
}
