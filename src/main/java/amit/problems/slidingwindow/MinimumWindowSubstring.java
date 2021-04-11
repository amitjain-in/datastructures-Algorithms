package amit.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));// abdec
        System.out.println(findSubstring("abdbca", "abc"));// bca
        System.out.println(findSubstring("adcad", "abc")); // ""
    }


    public static String findSubstring(String str, String pattern) {
        int start = 0, matched = 0, minLen = str.length() + 1, resultStart = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            patternMap.put(chr, patternMap.getOrDefault(chr, 0) + 1);

        // try to extend the range [start, windowEnd]
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (patternMap.containsKey(c)) {
                patternMap.put(c, patternMap.get(c) - 1);
                if (patternMap.get(c) >= 0) {// count every matching of a character}
                    matched++;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    resultStart = start;
                }

                char startC = str.charAt(start++);
                Integer count = patternMap.get(startC);

                if (count !=  null) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (count == 0) {
                        matched--;
                    }
                    patternMap.put(startC, count + 1);
                }
            }
        }

        return minLen > str.length() ? "" : str.substring(resultStart, resultStart + minLen);
    }

    private static Map<Character, Integer> getPatternCount(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
