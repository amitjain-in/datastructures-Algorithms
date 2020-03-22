package amit.problems.strings;

import java.util.*;

/**
 * Given a paragraph find which is the most common word in that paragraph but which is not included in the banned word list.
 * The words input could be multi-case but you are expected to handle it.
 *
 * The input guarantees that there is only one most common word.
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> words = toWords(paragraph);
        HashSet<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        list.sort(Map.Entry.comparingByValue());

        ListIterator<Map.Entry<String, Integer>> li = list.listIterator(list.size());//Reverse iterator since we need to start from highest occurrence.
        while(li.hasPrevious()) {
            Map.Entry<String, Integer> kv = li.previous();
            String word = kv.getKey();
            if(!bannedWords.contains(word)) {
                return word;
            }
        }
        return null;
    }

    static Map<String, Integer> toWords(String paragraph) {
        Map<String, Integer> wordsWithOccurrences = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isChar = false;
        for(char car: paragraph.toCharArray()) {
            isChar = isChar(car);
            if(isChar) {
                sb.append(car);
            } else {
                if(sb.length() > 0) {
                    wordsWithOccurrences.merge(sb.toString().toLowerCase(), 1, Integer::sum);
                    sb = new StringBuilder();
                }
            }
        }
        if(isChar) {//if the last character was alphabet then we need to count it here.
            wordsWithOccurrences.merge(sb.toString().toLowerCase(), 1, Integer::sum);
        }

        return wordsWithOccurrences;
    }

    static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
