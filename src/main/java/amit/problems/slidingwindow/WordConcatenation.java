package amit.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once
 * without any overlapping of words. It is given that all words are of the same length.
 */
public class WordConcatenation {

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }

    //Status works for two test cases, haven't tested for a lot
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String, Integer> patternCount = getWordMap(words);
        int wordLen = words[0].length();
        int matchLength = words[0].length() * words.length;
        int matched = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 >= wordLen) {
                String c = str.substring(i - wordLen + 1, i + 1);
                if (patternCount.containsKey(c)) {
                    patternCount.put(c, patternCount.get(c) - 1);
                    if (patternCount.get(c) == 0) {
                        matched++;
                    }
                    if (matched == patternCount.size()) {
                        resultIndices.add(i - matchLength + 1);
                    }
                }
                if (i >= matchLength - 1) {
                    String startC = str.substring(i - matchLength + 1, i - matchLength + wordLen + 1);
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
        }
        return resultIndices;
    }

    public static Map<String, Integer> getWordMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        return wordMap;
    }

    //This is the official solution from educative.io
    public static List<Integer> findWordConcatenationOther(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }
}
