package amit.problems.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
public class SortColours {

    public static void main(String[] args) {
        SortColours s = new SortColours();
        s.sort(new int[]{2, 0, 1});
        s.sort(new int[]{2, 0, 2, 1, 1, 0});
        s.sort(new int[]{0, 0, 0});
        s.sort(new int[]{0, 0, 1});
        s.sort(new int[]{1, 2, 1});
        s.sort(new int[]{1, 0, 1});
        s.sort(new int[]{2, 1, 1});
        s.sort(new int[]{2, 1, 0});
        s.sort(new int[]{2, 1, 2});
        s.sort(new int[]{0, 2, 2, 2, 0, 2, 1, 1});
        s.sort(new int[]{0});
        s.sort(new int[]{1});
        s.sort(new int[]{2});
    }

    //Status Works
    public void sort(int[] nums) {

        int zeroes = 0;
        int twos = nums.length;

        for (int i = zeroes; i < twos; i++) {

            while (zeroes < nums.length && nums[zeroes] == 0) {
                zeroes++;
                i++;
            }

            while (twos > 0 && nums[twos - 1] == 2) {
                twos--;
            }

            if (i >= 0 && i < twos && twos > 0 && nums[i] == 2) {
                swap(nums, --twos, i);
            }
            if (i >= 0 && i < twos && nums[i] == 0 && zeroes < nums.length) {
                swap(nums, zeroes++, i);
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
