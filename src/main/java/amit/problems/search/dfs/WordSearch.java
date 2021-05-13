package amit.problems.search.dfs;

/**
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    //Works
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if(exist(board, word, 0, row, col, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited) {
        if(wordIndex == word.length()) {//Word has ended
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {//Bound and visited check
            return false;
        }

        if(word.charAt(wordIndex) == board[row][col]) {
            visited[row][col] = true;
            if(exist(board, word, wordIndex + 1, row + 1, col, visited)
                    || exist(board, word, wordIndex + 1, row, col + 1, visited)
                    || exist(board, word, wordIndex + 1, row - 1, col, visited)
                    || exist(board, word, wordIndex + 1, row, col - 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
