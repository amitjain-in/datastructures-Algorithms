package amit.problems.games;

import java.util.HashSet;

public class SudokuSolver {

    private static final int MAZE_SIZE = 9;

    public static void main(String[] args) {

        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println(sudokuSolver.solve(sudokuSolver.parseString("")));
    }

    /**
     * This method doesn't use backtracking algorithm.
     *
     * @param maze - The 9 X 9 sudoku maze
     * @return - true if we have solved this maze or false if failed to do so.
     */
    public boolean solve(int[][] maze) {
        //Iterate over all
        return false;
    }

    private void print(int[][] maze) {
        System.out.println("//////////////////////////////");
        for (int row = 0; row < MAZE_SIZE; row++) {
            for (int col = 0; col < MAZE_SIZE; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("//////////////////////////////");
    }

    /**
     * This doesn't do any validation.
     *
     * @param str - Your maze in string
     * @return - your maze in (MAZE_SIZE * MAZE_SIZE) int array
     */
    private int[][] parseString(String str) {
        int[][] maze = new int[MAZE_SIZE][MAZE_SIZE];
        String[] rows = str.split(",");
        int rowCount = 0;
        for (String row : rows) {
            int colCount = 0;
            String[] cols = row.split(" ");
            for (String cell : cols) {
                maze[rowCount][colCount] = Integer.parseInt(cell.trim());
                colCount++;
            }
            rowCount++;
        }
        return maze;
    }

    /**
     * This method doesn't use backtracking algorithm.
     *
     * @param maze - The 9 X 9 sudoku maze
     * @return - true if we have solved this maze or false if failed to do so.
     */
    public boolean solveBackTrack(int[][] maze) {
        return false;
    }

    static class SudokuCell {
        int val = 0;
        HashSet<Integer> possibilities = new HashSet<>();
    }
}
