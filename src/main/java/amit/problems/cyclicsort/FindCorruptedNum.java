package amit.problems.cyclicsort;

import java.util.Arrays;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated
 * which also resulted in one number going missing. Find both these numbers.
 */
public class FindCorruptedNum {

    public static int[] findNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        int[] corrupt = new int[]{-1, -1};
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                corrupt[0] = nums[i];
                corrupt[1] = i + 1;
                break;
            }
        }

        return corrupt;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers(new int[]{3, 1, 2, 5, 2})));
        System.out.println(Arrays.toString(findNumbers(new int[]{3, 1, 2, 3, 6, 4})));
    }
}
