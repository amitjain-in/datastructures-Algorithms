package amit.problems.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSizeSubArraySum {

    public static void main(String[] args) {
        MinSizeSubArraySum ms = new MinSizeSubArraySum();
        System.out.println(ms.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));//2
        System.out.println(ms.minSubArrayLen(4, new int[]{1, 4, 4}));//1
        System.out.println(ms.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));//0
        System.out.println(ms.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));//3
        System.out.println(ms.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));//3

    }

    //Works but nlogn solution
    public int minSubArrayLen(int target, int[] nums) {
        TreeMap<Integer, Integer> sumMap = new TreeMap<>();
        int minLen = Integer.MAX_VALUE;

        int sum = 0;
        sumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.put(sum, i);
            if (nums[i] == target) {
                return 1;
            }
            Map.Entry<Integer, Integer> start = sumMap.floorEntry(sum - target);
            if (start != null) {
                minLen = Math.min(minLen, i - start.getValue());
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //
    public int minSubArrayLenOptimised(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (right < a.length) {
            sum += a[right++];

            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= a[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
