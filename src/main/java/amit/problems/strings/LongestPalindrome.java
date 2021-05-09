package amit.problems.strings;

/**
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
public class LongestPalindrome {

    //Status: works
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String maxPalindrome = "";
        for(int i = 0 ; i < s.length(); i++) {

            maxPalindrome = findLongestPalindrome(s, i, i, maxPalindrome, maxLength);
            if(maxPalindrome.length() > maxLength) {
                maxLength = maxPalindrome.length();
            }

            maxPalindrome = findLongestPalindrome(s, i, i + 1, maxPalindrome, maxLength);
            if(maxPalindrome.length() > maxLength) {
                maxLength = maxPalindrome.length();
            }

        }
        return maxPalindrome;
    }

    public String findLongestPalindrome(String s, int start, int end, String maxPalindrome, int maxLength) {
        boolean foundMatching = true;
        while(start >=0 && end < s.length() && foundMatching) {

            if(s.charAt(start) == s.charAt(end)) {
                if(end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    maxPalindrome = s.substring(start, end + 1);
                }
            } else {
                foundMatching = false;
            }
            start--;
            end++;
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("babad"));//bab pr aba
        System.out.println(lp.longestPalindrome("cbbd"));//bb
        System.out.println(lp.longestPalindrome("a"));//a
        System.out.println(lp.longestPalindrome("ac"));//a
        System.out.println(lp.longestPalindrome("ccc"));//ccc
        System.out.println(lp.longestPalindrome("aaaa"));//aaaa
    }
}
