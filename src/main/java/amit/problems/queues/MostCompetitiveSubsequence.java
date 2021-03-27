package amit.problems.queues;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * Status not working
 */
public class MostCompetitiveSubsequence {

    public static void main(String[] args) {
        MostCompetitiveSubsequence mostCompetitiveSubsequence = new MostCompetitiveSubsequence();
        System.out.println(Arrays.toString(mostCompetitiveSubsequence.mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitiveSubsequence.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));

        //[10,23,61,62,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71]
        System.out.println(Arrays.toString(mostCompetitiveSubsequence.mostCompetitive(new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71}, 24)));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        int i = nums.length;
        while (--i >= 0) {
            if (stack.size() < k || stack.peek() > nums[i]) {
                stack.push(nums[i]);
            }
        }

        int[] result = new int[k];
        for (int l = 0; l < k; l++) {
            result[l] = stack.pop();
        }
        return result;
    }
}
