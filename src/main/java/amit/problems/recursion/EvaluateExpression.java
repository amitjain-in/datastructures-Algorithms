package amit.problems.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 */
public class EvaluateExpression {

    public static List<Integer> diffWaysToEvaluateExpression(String input, Map<String, List<Integer>> memory) {
        if (memory.containsKey(input)) {
            return memory.get(input);
        }

        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and add it to output.
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    // break the equation here into two parts and make recursively calls
                    List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i), memory);
                    List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1), memory);
                    for (int l : left) {
                        for (int r : right) {
                            if (chr == '+')
                                result.add(l + r);
                            else if (chr == '-')
                                result.add(l - r);
                            else if (chr == '*')
                                result.add(l * r);
                        }
                    }
                }
            }
        }
        memory.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3", new HashMap<>());//7 = 1 + (2*3) and 9 = (1 + 2) * 3
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5", new HashMap<>());
        System.out.println("Expression evaluations: " + result);
    }
}
