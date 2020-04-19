package amit.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k
 */
public class SubArraySumOfK {

    //O(n^2)
    public int subArraySumBruteForce(int[] nums, int k) {
        int sum;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //O(n)
    public int subArraySumOptimised(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        sumMap.put(0, 1);//Required in case nums[0] == k
        for (int num : nums) {
            sum += num;
            count += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, 1);
        }
        return count;
    }

    //Some test cases fail.
    public int oneMoreWithoutMap(int[] nums, int k) {

        if (nums.length == 0) {
            return 0;
        }

        int sum = nums[0];
        int count = sum == k ? 1 : 0;
        int start = 0;
        int end = 1;
        if (end < nums.length) {
            sum += nums[end];
        }

        while (start <= end && end < nums.length) {
            if (sum <= k) {
                if (sum == k) {
                    count++;
                }
                System.out.println("<= sum=" + sum + " count=" + count + " start=" + start + " end=" + end);
                if (end == nums.length - 1 && start < end) {
                    sum -= nums[start++];
                } else {
                    end++;
                    if (end < nums.length) {
                        sum += nums[end];
                    }
                }
            } else {
                System.out.println("> sum=" + sum + " count=" + count + " start=" + start +  " end=" + end);
                if(start < end) {
                    sum -= nums[start++];
                } else {
                    end++;
                    if (end < nums.length) {
                        sum += nums[end];
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySumOfK subArraySumOfK = new SubArraySumOfK();
//        subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, 4, 1}, 4);//, 1);
//        subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, -4, 1}, 2);//, 2);
//        System.out.println(subArraySumOfK.oneMore(new int[]{-1, -1, 1}, 0));//, 1);
        System.out.println(subArraySumOfK.oneMoreWithoutMap(new int[]{100, 1, 2, 3, 100, 1, 2, 3, 4}, 3));//, 1);
//        subArraySumOfK.subArraySumBruteForce(new int[]{1, 1, 2}, 2);//, 2);
    }
}
