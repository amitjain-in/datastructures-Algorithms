package amit.problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));//true
        System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));//true
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));//false
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return wordBreak(s, dict, new HashMap<>());
    }

    public boolean wordBreak(String s, HashSet<String> dict, HashMap<String, Boolean> memo) {

        if (memo.get(s) != null) {
            return memo.get(s);
        }

        int i = 1;
        while (i <= s.length()) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                if (first.length() == s.length() || wordBreak(s.substring(i), dict, memo)) {
                    return true;
                }
            }
            i++;
        }
        memo.put(s, false);
        return false;
    }
}
