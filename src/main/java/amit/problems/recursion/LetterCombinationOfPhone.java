package amit.problems.recursion;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationOfPhone {

    //Status: works
    public List<String> letterCombinations(String digits) {
        return combinations(digits, getCharMap(), 0);
    }

    private List<String> combinations(String digits, Map<Character, char[]> charMap, int digitIndex) {
        List<String> results = new LinkedList<>();
        if(digitIndex == digits.length()) {
            return results;
        }

        char digit = digits.charAt(digitIndex);
        char[] chars = charMap.get(digit);
        List<String> subResults = combinations(digits, charMap, digitIndex + 1);
        for(char c: chars) {
            if (!subResults.isEmpty()) {
                for(String subResult: subResults) {
                    results.add(c + subResult);
                }
            } else {
                results.add(c + "");
            }
        }

        return results;
    }

    private Map<Character, char[]> getCharMap() {
        Map<Character, char[]> charMap = new HashMap<>();
        charMap.put('2', new char[]{'a', 'b', 'c'});
        charMap.put('3', new char[]{'d', 'e', 'f'});
        charMap.put('4', new char[]{'g', 'h', 'i'});
        charMap.put('5', new char[]{'j', 'k', 'l'});
        charMap.put('6', new char[]{'m', 'n', 'o'});
        charMap.put('7', new char[]{'p', 'q', 'r', 's'});
        charMap.put('8', new char[]{'t', 'u', 'v'});
        charMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        return charMap;
    }

    public static void main(String[] args) {
        LetterCombinationOfPhone l = new LetterCombinationOfPhone();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("2"));
        System.out.println(l.letterCombinations(""));
    }
}
