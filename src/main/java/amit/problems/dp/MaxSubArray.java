package amit.problems.dp;

/**
 * https://leetcode.com/problems/maximum-subarray
 * Status: working
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));//6
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));//1
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));//23
    }

    public int maxSubArray(int[] nums) {
        int prevSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = Math.max(nums[i], prevSum + nums[i]);
            maxSum = Math.max(sum, maxSum);
            prevSum = sum;
        }

        return maxSum;
    }
}
