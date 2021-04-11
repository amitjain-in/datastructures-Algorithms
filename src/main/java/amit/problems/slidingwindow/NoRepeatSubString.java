package amit.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters
 */
public class NoRepeatSubString {


    public static void main(String[] args) {
        System.out.println(findLength("aabccbb"));//abc 3
        System.out.println(findLength("abbbb"));//ab 2
        System.out.println(findLength("abccde"));// adc or cde 3
    }

    public static int findLength(String str) {
        int start = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [start, windowEnd]
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (map.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'start' is already ahead of the last index of 'rightChar', we'll keep 'start'
                start = Math.max(start, map.get(rightChar) + 1);
            }
            map.put(rightChar, end); // insert the 'rightChar' into the map
            maxLen = Math.max(maxLen, end - start + 1); // remember the maximum length so far
        }

        return maxLen;
    }
}