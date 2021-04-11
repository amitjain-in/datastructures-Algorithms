package amit.problems.search;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Status: Works
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
//        System.out.println(search2DMatrix.searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        }, 61));
//
//        System.out.println(search2DMatrix.searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        }, 13));
//
//        System.out.println(search2DMatrix.searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        }, 10));

        System.out.println(search2DMatrix.searchMatrix(new int[][]{
                {1},
                {3}
        }, 3));
    }


    //Note you can also do a binary search on 2D ordered matrix in a single binary search.
    // like this https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = getRowIdx(matrix, target, 0, matrix.length - 1, matrix.length);
        if (rowIdx != -1) {
            return getColIdx(matrix, target, 0, matrix[0].length - 1, rowIdx) != -1;
        }
        return false;
    }

    int getRowIdx(int[][] matrix, int target, int left, int right, int rows) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (matrix[mid][0] <= target && (mid + 1 >= rows || matrix[mid + 1][0] > target)) {
            return mid;
        }
        if (matrix[mid][0] < target && (mid + 1 >= rows || matrix[mid + 1][0] <= target)) {
            return getRowIdx(matrix, target, mid + 1, right, rows);
        }
        return getRowIdx(matrix, target, left, mid - 1, rows);
    }

    int getColIdx(int[][] matrix, int target, int left, int right, int rowIdx) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (matrix[rowIdx][mid] == target) {
            return mid;
        }
        if (matrix[rowIdx][mid] < target) {
            return getColIdx(matrix, target, mid + 1, right, rowIdx);
        }
        return getColIdx(matrix, target, left, mid - 1, rowIdx);
    }
}
