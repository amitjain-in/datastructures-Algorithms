package amit.problems.arrays;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * https://leetcode.com/problems/spiral-matrix-ii *
 */
public class SpiralMatrix2 {

    //Status works
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int val = 1;
        int total = n * n;

        while (val <= total) {
            int row = rowStart;
            int col = colStart;

            for (; col <= colEnd && val <= total; col++) { //First row
                result[row][col] = val++;
            }
            row = ++rowStart;
            col = colEnd;

            for (; row <= rowEnd && val <= total; row++) { //Last Column
                result[row][col] = val++;
            }

            col = --colEnd;
            row = rowEnd;
            for (; col >= colStart && val <= total; col--) { //Last row
                result[row][col] = val++;
            }

            row = --rowEnd;
            col = colStart;
            for (; row >= rowStart && val <= total; row--) { //First Column
                result[row][col] = val++;
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        for (int i = 1; i < 20; i++) {
            System.out.println("n = " + i + "\nOutput\n" + ArrayUtils.printArray2d(ArrayUtils.wrapper(spiralMatrix2.generateMatrix(i))) + "\n");
        }
    }
}
