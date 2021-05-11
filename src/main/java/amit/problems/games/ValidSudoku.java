package amit.problems.games;

import java.util.Arrays;

/**
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    //Status works
    public boolean isValidSudoku(char[][] board) {
        boolean[] isPresent = new boolean[9];

        //Column wise
        for(int i = 0; i < 9; i++) {
            Arrays.fill(isPresent, false);
            for(int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c != '.') {
                    if(isPresent[c - '1']) {
                        return false;
                    }
                    isPresent[c - '1'] = true;
                }
            }
        }

        //Row wise
        for(int i = 0; i < 9; i++) {
            Arrays.fill(isPresent, false);
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(isPresent[c - '1']) {
                        return false;
                    }
                    isPresent[c - '1'] = true;
                }
            }
        }

        //Grid wise
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Arrays.fill(isPresent, false);
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        char c = board[i * 3 + k][j * 3 + l];
                        if(c != '.') {
                            if(isPresent[c - '1']) {
                                return false;
                            }
                            isPresent[c - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
