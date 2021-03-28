package amit.problems.dp;

import java.util.Arrays;

/**
 * Primitive algorithm that can be used as a base for spell correction features of various apps.
 */
public class LevenshteinDistance {

    public int distance(String pattern, String text) {
        int[][] dp = new int[pattern.length()][text.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < pattern.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i < text.length(); i++)
            dp[0][i] = i;

        return distance(pattern.toCharArray(), text.toCharArray(), pattern.length() - 1,
                text.length() - 1, dp);
    }

    private int distance(char[] pattern, char[] text, int patternStart, int textStart, int[][] dp) {

        if (0 == patternStart && 0 == textStart) {
            return pattern[patternStart] == text[textStart] ? 0 : 1;
        } else if (0 == patternStart || 0 == textStart) {
            return Math.abs(textStart - patternStart);
        }

        if (dp[patternStart][textStart] != Integer.MAX_VALUE) {
            return dp[patternStart][textStart];
        }

        // Contains three conditions
        // 1) Assume pattern/text not matching and we reduce with pattern char by 1,
        // 2) Same as 1) but reduce text char by 1 instead of pattern
        // 3) its a match or not but we reduce both string comparison by 1. This way we will get minimum of all possible
        int distance = Math.min(Math.min(
                distance(pattern, text, patternStart - 1, textStart, dp) + 1,
                distance(pattern, text, patternStart, textStart - 1, dp) + 1),
                (pattern[patternStart] == text[textStart] ? 0 : 1) + distance(pattern, text, patternStart - 1, textStart - 1, dp));

        dp[patternStart][textStart] = distance;
        return distance;
    }
}
