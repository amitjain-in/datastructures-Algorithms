package amit.problems.strings;

import java.util.Arrays;

/**
 * Given two strings s1 and s2 find the longest subsequence which is common across both the strings.
 * e.g.
 * Input: s1 = "CBCADE" s2 = "ABDADE" Output: "BADE"
 * Input: s1 = "aaaaaa" s2 = "aa" Output: "aa"
 * Input: s1 = "abc" s2 = "def" Output: ""
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequenceTabular("CBCADE", "ABDADE"));
        System.out.println(lcs.longestCommonSubsequenceTabular("aaaaaa", "aa"));
        System.out.println(lcs.longestCommonSubsequenceTabular("abc", "abc"));
        System.out.println(lcs.longestCommonSubsequenceTabular("abc", "def"));
        System.out.println(lcs.longestCommonSubsequenceTabular("abcde", "ace"));
    }

    //Status works: Can be optimised to use variables instead of dp array;
    public String longestCommonSubsequenceTabular(String s1, String s2) {
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];

        Arrays.fill(dp[0], "");
        for (int i = 1; i <= s1.length(); i++) {
            Arrays.fill(dp[i], "");
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    //Status works:  https://leetcode.com/problems/longest-common-subsequence/
    public int longestCommonSubsequenceTabularLeetCode(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
