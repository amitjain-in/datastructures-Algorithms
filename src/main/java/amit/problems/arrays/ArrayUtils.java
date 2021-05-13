package amit.problems.arrays;

import java.util.Arrays;

public class ArrayUtils {


    public static <T> String printArray2d(T[][] grid) {
        StringBuilder result = new StringBuilder();
        for (T[] rows : grid) {
            result.append(Arrays.toString(rows)).append("\n");
        }

        return result.toString();
    }

    public static Integer[][] wrapper(int[][] grid) {
        Integer[][] wrapper = new Integer[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                wrapper[row][col] = grid[row][col];
            }
        }

        return wrapper;
    }
}
