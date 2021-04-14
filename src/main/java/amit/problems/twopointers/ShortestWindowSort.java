package amit.problems.twopointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 */
public class ShortestWindowSort {

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(sort(new int[]{1, 2, 3}));
        System.out.println(sort(new int[]{3, 2, 1}));
    }

    public static int sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        // find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        if (low == arr.length - 1) // if the array is sorted
            return 0;

        // find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1])
            high--;

        // find the maximum and minimum of the subarray
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int k = low; k <= high; k++) {
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > min)
            low--;
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < max)
            high++;

        return high - low + 1;
    }
}
