package amit.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    //Status works
    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (total > 0) {
            int row = rowStart;
            int col = colStart;

            for (; col <= colEnd && total > 0; col++) { //First row
                result.add(matrix[row][col]);
                total--;
            }

            row = ++rowStart;
            col = colEnd;
            for (; row <= rowEnd && total > 0; row++) { //Last Column
                result.add(matrix[row][col]);
                total--;
            }

            col = --colEnd;
            row = rowEnd;
            for (; col >= colStart && total > 0; col--) { //Last row
                result.add(matrix[row][col]);
                total--;
            }

            row = --rowEnd;
            col = colStart;
            for (; row >= rowStart && total > 0; row--) { //First Column
                result.add(matrix[row][col]);
                total--;
            }
            colStart++;
        }

        return result;
    }


    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}
        ));//1,2,3,6,9,8,7,4,5

        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}}
        ));//1,2,3,4,8,12,11,10,9,5,6,7

        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1}}
        ));//1

        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1, 2}}
        ));//1,2
        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1}, {2}}
        ));//1,2
    }
}
