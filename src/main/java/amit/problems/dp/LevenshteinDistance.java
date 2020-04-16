package amit.problems.dp;

import java.util.Arrays;

public class LevenshteinDistance {

    public int distance(String pattern, String text) {
        int[][] dp = new int[pattern.length()][text.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return distance(pattern.toCharArray(), text.toCharArray(), pattern.length() - 1, text.length() - 1, dp);
    }

    private int distance(char[] pattern, char[] text, int patternStart, int textStart, int[][] dp) {

        if (0 == patternStart || 0 == textStart) {
            return Math.abs(textStart - patternStart);
        }

        if(dp[patternStart][textStart] != -1) {
           return dp[patternStart][textStart];
        }

        int distance = Math.min(Math.min(
                distance(pattern, text, patternStart - 1, textStart, dp) + 1,
                distance(pattern, text, patternStart, textStart - 1, dp) + 1),
                (pattern[patternStart] == text[textStart] ? 0 : 1) + distance(pattern, text, patternStart - 1, textStart - 1, dp));

        dp[patternStart][textStart] = distance;
        return distance;
    }
}
