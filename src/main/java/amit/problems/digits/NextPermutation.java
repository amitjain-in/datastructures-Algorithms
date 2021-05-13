package amit.problems.digits;

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 */
public class NextPermutation {

    //Works
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        //1. Find the min index which is not reverse sorted from back e.g. 21543 the number '1' at index '1'
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = i + 1;
            //2. Find the smallest number from out index i step 1 to n -1 which is just bigger than our number at index i;
            while (j < nums.length && nums[i] < nums[j]) {
                j++;
            }
            //3. Then exchange it with number at i. This will help setting the next permutation. e.g. 21543 now becomes 23541
            swap(nums, i, j - 1);
        }

        i++;
        int k = nums.length - 1;
        //4. Reverse sort from next index of i till end of array, Because we know this part of array is sorted in descending order from step 1; 23541 now becomes 23145
        while (i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
    }

    private static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}

