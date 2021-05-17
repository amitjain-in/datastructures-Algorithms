package amit.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x.
 * For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 *     0 <= i < j < nums.length
 *     nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 *
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7
 *
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 */
public class NicePairs {//If there ever was a double meaning class name.

    //Status works
    public int countNicePairs(int[] nums) {

        Map<Integer, Integer> reverseSums = new HashMap<>();

        for (int num : nums) {
            int reverseSum = num - reverse(num);
            reverseSums.merge(reverseSum, 1, Integer::sum);
        }

        int count = 0;
        for (int reverseSum : reverseSums.values()) {
            if (reverseSum > 1) {
                long val = (long) reverseSum * (reverseSum - 1) / 2; //This is basically a sum of  n -1 numbers formulra.
                count = (int) ((count + val) % (1_000_000_000 + 7));//Leetcode comes up with this weird conditions for modulo answers. Hate it.
            }
        }

        return count;
    }


    private int reverse(int num) {
        int reverse = 0;

        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        NicePairs nicePairs = new NicePairs();
        System.out.println(nicePairs.countNicePairs(new int[]{13, 10, 35, 24, 76}));//4
    }
}
