package amit.problems.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams
 */
public class GroupAnagrams {

    //Status works
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);//Given constraints of english lower letters. More efficient is this -> char[] ca = new char[26]; for (char c : s.toCharArray()) ca[c - 'a']++;
            map.computeIfAbsent(String.copyValueOf(chars), w -> new LinkedList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(ga.groupAnagrams(new String[]{"a"}));
        System.out.println(ga.groupAnagrams(new String[]{""}));
    }
}
