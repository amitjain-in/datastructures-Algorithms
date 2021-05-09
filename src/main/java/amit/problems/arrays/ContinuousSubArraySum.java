package amit.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubArraySum {

    //Status works
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> kSum = new HashMap<>();
        kSum.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            Integer prev = kSum.putIfAbsent(sum, i);
            if (prev != null && i - prev > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySum c = new ContinuousSubArraySum();
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));//True [2,4]
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));//True [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));//False
        System.out.println(c.checkSubarraySum(new int[]{7, 6, 7}, 6));//False
        System.out.println(c.checkSubarraySum(new int[]{2, 4}, 6));//True
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));//True
        System.out.println(c.checkSubarraySum(new int[]{5, 0, 0, 0, 0}, 3));//True Because [0,0] is continuous sub array sum of 0 which is divisible
        System.out.println(c.checkSubarraySum(new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0}, 5));//False
    }
}
