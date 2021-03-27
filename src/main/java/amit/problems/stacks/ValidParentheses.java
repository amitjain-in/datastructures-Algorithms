package amit.problems.stacks;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/valid-parentheses/
 *
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
    }

    //Works
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                } else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                } else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
