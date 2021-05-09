package amit.problems.twopointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * You may return the answer in any order.
 * <p>
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    //Status: works
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                findTuples(nums, nums[i], nums[j], j + 1, target - (nums[i] + nums[j]), results);
            }
        }


        return results;
    }

    private void findTuples(int[] nums, int first, int second, int startIdx, int target, List<List<Integer>> results) {
        int left = startIdx;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                results.add(Arrays.asList(first, second, nums[left], nums[right]));
                left++;
                right--;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right > left && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }


    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }
}
