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

    //O(n) with prefix sum - Works
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

    public static void main(String[] args) {
        SubArraySumOfK subArraySumOfK = new SubArraySumOfK();
        subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, 4, 1}, 4);//, 1);
        subArraySumOfK.subArraySumBruteForce(new int[]{2, 3, -4, 1}, 2);//, 2);;
        subArraySumOfK.subArraySumBruteForce(new int[]{1, 1, 2}, 2);//, 2);

        subArraySumOfK.subArraySumOptimised(new int[]{2, 3, 4, 1}, 4);//, 1);
        subArraySumOfK.subArraySumOptimised(new int[]{2, 3, -4, 1}, 2);//, 2);;
        subArraySumOfK.subArraySumOptimised(new int[]{1, 1, 2}, 2);//, 2);
    }
}
