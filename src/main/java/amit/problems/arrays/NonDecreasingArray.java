package amit.problems.arrays;

/**
 * https://leetcode.com/problems/non-decreasing-array/submissions/
 * status: not working
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        //   System.out.println(nonDecreasingArray.checkPossibility(new int[]{3, 4, 2, 3}));

        System.out.println(nonDecreasingArray.checkPossibility(new int[]{5, 7, 1, 8}));
    }

    public boolean checkPossibility(int[] nums) {

        boolean possible = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                int j = i - 1;
                while (--j >= 0) {
                    if (nums[j] >= nums[i]) {
                        possible = false;
                    }
                }
            }
        }

        return possible;
    }

}
