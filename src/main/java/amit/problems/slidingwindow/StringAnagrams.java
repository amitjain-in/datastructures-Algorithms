package amit.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * *
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 */
public class StringAnagrams {


    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

    //Status works, T: O (n + m) S: O(m)
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> results = new ArrayList<Integer>();
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
                    results.add(end - pattern.length() + 1);
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
        return results;
    }


    private static Map<Character, Integer> getPatternCount(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}


