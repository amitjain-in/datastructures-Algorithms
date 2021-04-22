package amit.problems.strings;

import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicateLetters("bcabc"));//abc
        System.out.println(rd.removeDuplicateLetters("cbacdcbc"));//acdb
    }

    //Status works: Taken from https://leetcode.com/problems/remove-duplicate-letters/discuss/76769/Java-solution-using-Stack-with-comments;
    public String removeDuplicateLetters(String sr) {

        int[] res = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = sr.toCharArray();
        for (char c : ch) {  //count number of occurences of character
            res[c - 'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for (char s : ch) {
            index = s - 'a';
            res[index]--;   //decrement number of characters remaining in the string to be analysed
            if (visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!st.isEmpty() && s < st.peek() && res[st.peek() - 'a'] != 0) {
                visited[st.pop() - 'a'] = false;
            }
            st.push(s); //add current character and mark it as visited
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
