package amit.problems.arrays;

import java.util.Arrays;

/**
 * You are given an array and a method <code>reverse</code> which will reverse the array upto <code>k</code> elements starting from 0.
 * Using the help of this method you need to sort the array.
 */
public class SortUsingReverseK {

    public static void main(String[] args) {
        int[] test = new int[]{5, 7, 3, 2, 1};
        sortUsingReverseK(test);
        System.out.println(Arrays.toString(test));
//        testReverse();
    }

    //Inefficient
    private static void sortUsingReverseK(int[] arr) {
        //find the max element in the array reverse to that point so that the element comes first and then reverse full array.
        for (int i = 0; i < arr.length; i++) {
            sortUsingReverseKInternal(arr, arr.length - i);
        }
    }

    private static void sortUsingReverseKInternal(int[] arr, int length) {
        if (length == 1) {
            return;
        }
        int maxIdx = 0;//Assume first element is the max
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        if(maxIdx != 0) {
            reverse(arr, maxIdx);//Bring max element to first index of array
        }
        reverse(arr, length - 1);//Now send the max element to tracking array length
        sortUsingReverseKInternal(arr, length - 1);//Now reduce tracking array by 1 and repeat
    }

    /**
     * Reverses an array up to k elements starting from 0.
     * @param arr - The array to reverse
     * @param k - Till the index to reverse
     */
    private static void reverse(int[] arr, int k) {
        for (int i = 0; i <= k / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = tmp;
        }
    }

    private static void testReverse() {
        int[] test = new int[]{2, 3, 1, 4, 5, 6};
        reverse(test, 3);
        System.out.println(Arrays.toString(test));

        int[] test1 = new int[]{2, 3, 1, 4, 5, 6};
        reverse(test1, 1);
        System.out.println(Arrays.toString(test1));
    }
}
