package amit.problems.twopointers;

import java.util.Arrays;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 */
public class DutchFlag {

    public static void main(String[] args) {
        test(new int[]{2, 2, 0, 1, 2, 0});
        test(new int[]{1, 0, 2, 1, 0});
    }

    public static void test(int[] arr) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int zero = 0;
        int two = arr.length - 1;
        for (int i = 0; i <= two; ) {
            if (arr[i] == 0) {
                swap(arr, i, zero);
                zero++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, two);
                two--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if(i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
