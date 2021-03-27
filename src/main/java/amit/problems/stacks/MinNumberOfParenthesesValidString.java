package amit.problems.stacks;

import java.util.Stack;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
 * so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinNumberOfParenthesesValidString {

    public static void main(String[] args) {
        MinNumberOfParenthesesValidString minNumberOfParenthesesValidString = new MinNumberOfParenthesesValidString();
        System.out.println(minNumberOfParenthesesValidString.minAddToMakeValid("())"));
        System.out.println(minNumberOfParenthesesValidString.minAddToMakeValid("((("));
        System.out.println(minNumberOfParenthesesValidString.minAddToMakeValid("()"));
        System.out.println(minNumberOfParenthesesValidString.minAddToMakeValid("()))(("));
    }

    //Status: Works
    public int minAddToMakeValid(String S) {

        Stack<Character> stack = new Stack<>();

        int invalidCombo = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                invalidCombo++;
            }
        }
        return stack.size() + invalidCombo;
    }

}
