package amit.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
 * <p>
 * If a string has ‘n’ distinct characters, it will have n! permutations.
 */
public class StringPermutation {

    public static void main(String[] args) {
        System.out.println(findPermutationOptimised("oidbcaf", "abc")); //true
        System.out.println(findPermutationOptimised("odicf", "dc")); //false
        System.out.println(findPermutationOptimised("bcdxabcdy", "bcdyabcdx")); //true
        System.out.println(findPermutationOptimised("aaacb", "abc")); //true
    }

    //Status works but o((n - k) * k) where it can be solved in o (n + k) complexity where n is length of string and k is length of pattern
    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> patternCount = getPatternCount(pattern);
        int start = 0;
        int end = pattern.length();

        while (end <= str.length()) {
            String sub = str.substring(start, end);
            if (isPermutation(sub, patternCount)) {
                return true;
            }
            start++;
            end++;
        }
        return false;
    }

    private static boolean isPermutation(String sub, Map<Character, Integer> patternCount) {
        Map<Character, Integer> subMap = getPatternCount(sub);
        for (Map.Entry<Character, Integer> entry : subMap.entrySet()) {
            if (!entry.getValue().equals(patternCount.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getPatternCount(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    //o(n + m)
    public static boolean findPermutationOptimised(String str, String pattern) {
        Map<Character, Integer> patternCount = getPatternCount(pattern);
        int matched = 0;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (patternCount.containsKey(c)) {
                patternCount.put(c, patternCount.get(c) - 1);
                if (patternCount.get(c) == 0) {
                    matched++;
                }
                if (matched == patternCount.size()) {
                    return true;
                }
            }
            if (end >= pattern.length() - 1) {
                char startC = str.charAt(end - pattern.length() + 1);
                Integer count = patternCount.get(startC);
                if (count != null) {
                    if (count == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back for matching
                    patternCount.put(startC, count + 1);
                }
            }
        }
        return false;
    }
}
