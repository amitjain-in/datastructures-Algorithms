package amit.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 *
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Status: works
 */
public class GenerateParentheses {

    /**
     *
     * @param num - Please note num here is pair, so our return string lengths will be of 2 * num.
     * @return - The list of all permutations you requested sir.
     */
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        generateValidParentheses(num * 2, "", 0, result);
        return result;
    }

    public static void generateValidParentheses(int remain, String str, int opens, List<String> result) {
        if(remain == 0) {
            result.add(str);
        }
        if (remain > opens) {//This means that we can add open more brackets and then next method call will close it.
            generateValidParentheses(remain - 1, str + '(', opens + 1, result);
        }
        if(opens > 0) {
            generateValidParentheses(remain - 1, str + ')', opens - 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(4);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
