package amit.problems.strings;

/**
 * https://leetcode.com/problems/regular-expression-matching
 */
public class RegexPattern {

    //Status Works
    public boolean isMatch(String string, String pattern) {

        if (string == null || pattern == null) {
            return false;
        }
        boolean[][] dp = new boolean[string.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int p = 0; p < pattern.length(); p++) {
            if (pattern.charAt(p) == '*' && dp[0][p - 1]) {
                dp[0][p + 1] = true;
            }
        }
        for (int c = 1; c <= string.length(); c++) {
            for (int p = 1; p <= pattern.length(); p++) {
                char pc = pattern.charAt(p - 1);
                char sc = string.charAt(c - 1);
                if (pc == '.' || pc == sc) {
                    dp[c][p] = dp[c - 1][p - 1];
                }

                if (pc == '*') {
                    if (pattern.charAt(p - 2) != sc && pattern.charAt(p - 2) != '.') {
                        dp[c][p] = dp[c][p - 2];
                    } else {
                        dp[c][p] = (dp[c][p - 1] || dp[c - 1][p] || dp[c][p - 2]);//a* multiple || a* single || a* empty a
                    }
                }
            }
        }
        return dp[string.length()][pattern.length()];
    }
}
