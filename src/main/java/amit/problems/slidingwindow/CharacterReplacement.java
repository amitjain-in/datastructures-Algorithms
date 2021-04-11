package amit.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 */
public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));//5 Replace cc by bb
        System.out.println(findLength("abbcb", 1));//4 Replace c by b
        System.out.println(findLength("abccde", 1));//3 Replace b or d by c
    }

    public static int findLength(String str, int k) {
        int start = 0, maxLen = 0, repeats = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        // try to extend the range [start, windowEnd]
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            repeats = Math.max(repeats, freqMap.get(c));

            // current window size is from start to end, overall we have a letter which is
            // repeating 'repeats' times, this means we can have a window which has one letter
            // repeating 'repeats' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (end - start + 1 - repeats > k) {
                char leftChar = str.charAt(start);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
