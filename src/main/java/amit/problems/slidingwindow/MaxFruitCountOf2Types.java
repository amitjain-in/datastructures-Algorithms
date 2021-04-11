package amit.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e.,
 * you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Pattern //sliding window
 * <p>
 * Status works;
 */
public class MaxFruitCountOf2Types {

    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));//3
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));//5
    }

    public static int findLength(char[] arr) {
        Map<Character, Integer> count = new HashMap<>();
        int max = 0;
        int start = 0;
        final int fruitTypes = 2;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.size() > fruitTypes) {
                int chars = count.get(arr[start]);
                count.put(arr[start], --chars);
                if (chars == 0) {
                    count.remove(arr[start]);
                }
                start++;
            }

            max = Math.max(i - start + 1, max);
        }

        return max;
    }
}
