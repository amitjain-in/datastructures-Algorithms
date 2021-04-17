package amit.problems.dp;

/**
 * Given a string in numbers and a mapp of 1 -> 'a', 2 - 'b',.... 26 - 'z'. Find in how many ways can you decode this string.
 * <p>
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.decode("123"));
        System.out.println(decodeWays.decode("103"));
        System.out.println(decodeWays.decode("100")); //1 Because you need to utilise the full string to decode Hence 'A' is invalid as the remaining two 0s are not utilised.
        System.out.println(decodeWays.decode("010")); //0
        System.out.println(decodeWays.decode("12"));

        System.out.println(decodeWays.numDecodings("010"));
        System.out.println(decodeWays.numDecodings("010"));
    }

    public int decode(String s) {
        int[] memo = new int[s.length() + 1];
        return decode(s, s.length(), memo);
    }

    private int decode(String st, int i, int[] memo) {

        if (i == 0) {
            return 1;
        }

        if (memo[i] != 0) {
            return memo[i];
        }

        if (st.charAt(st.length() - i) == '0') {
            return 0;
        }

        int result = 0;
        result += decode(st, i - 1, memo);

        if (i >= 2 && Integer.parseInt(st.substring(st.length() - i, st.length() - i + 2)) <= 26) {
            result += decode(st, i - 2, memo);
        }
        memo[i] = result;
        return result;
    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) != '0') {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }

        return memo[0];
    }
}
