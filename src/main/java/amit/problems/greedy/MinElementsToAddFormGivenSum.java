package amit.problems.greedy;

/**
 * You are given an integer array nums and two integers limit and goal. The array nums has an interesting property that abs(nums[i]) <= limit.
 * <p>
 * Return the minimum number of elements you need to add to make the sum of the array equal to goal. The array must maintain its property that abs(nums[i]) <= limit.
 * <p>
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 * <p>
 * https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/
 * <p>
 * Status works
 */
public class MinElementsToAddFormGivenSum {

    public int minElements(int[] nums, int limit, int goal) {
        long total = 0;

        for (int num : nums) {
            total += num;//Do not use Arrays.stream(nums).sum() as it will cause integer overflow problems and return wrong result.
        }

        long diff = Math.abs(goal - total);
        return (int) (diff / limit + (diff % limit > 0 ? 1 : 0));
    }
}
