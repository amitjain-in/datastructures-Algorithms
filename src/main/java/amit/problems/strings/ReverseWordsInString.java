package amit.problems.strings;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("the sky is blue"));
        System.out.println(reverseWordsInString.reverseWordsOptimised("the sky is blue"));
    }

    //Cleared all testcases but is very slow :(
    public String reverseWords(String s) {
        Queue<Character> wordStack = new LinkedBlockingQueue<>();
        String trimmed = s.trim();
        Stack<String> words = new Stack<>();
        for(char c: trimmed.toCharArray()) {
            if(c == ' ') {
                if(!wordStack.isEmpty()) {
                    StringBuilder word = new StringBuilder();
                    while(!wordStack.isEmpty()) {
                        word.append(wordStack.remove());
                    }
                    words.push(word.toString());
                }
            } else {
                wordStack.offer(c);
            }
        }
        if(!wordStack.isEmpty()) {
            StringBuilder word = new StringBuilder();
            while(!wordStack.isEmpty()) {
                word.append(wordStack.remove());
            }
            words.push(word.toString());
        }
        StringBuilder result = new StringBuilder();
        while(!words.isEmpty()) {
            result.append(words.pop()).append(!words.isEmpty() ? " " : "");
        }
        return result.toString();
    }

    public String reverseWordsOptimised(String s) {
        String trimmed = s.trim();
        Stack<String> words = new Stack<>();
        StringBuilder word = new StringBuilder();
        for(char c: trimmed.toCharArray()) {
            if(c == ' ') {
                if(word.length() > 0) {
                    words.push(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(c);
            }
        }
        if(word.length() > 0) {
            words.push(word.toString());
        }
        StringBuilder result = new StringBuilder();
        while(!words.isEmpty()) {
            result.append(words.pop()).append(!words.isEmpty() ? " " : "");
        }
        return result.toString();
    }
}
