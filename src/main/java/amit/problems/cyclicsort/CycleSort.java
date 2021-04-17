package amit.problems.cyclicsort;

import java.util.Arrays;

/**
 * Given unsorted array of integers 1 to n, sort them in-place in O(n) without any additional space;
 */
public class CycleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 4, 3, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, 1, 5, 4, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{2, 6, 4, 3, 1, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;//Keep swapping until we haven't found the correct number at ith index, hence the decrement operator over here.
            }
        }
    }
}
