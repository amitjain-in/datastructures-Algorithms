package amit.problems.search;

/**
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have duplicates.
 * <p>
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1
 */
public class UnknownBinarySearch {

    public static int search(int[] arr, int key) {
        if (arr[0] < arr[arr.length - 1]) {
            return binarySearch(arr, key, 0, arr.length - 1, (i, j) -> i < j);
        } else {
            return binarySearch(arr, key, 0, arr.length - 1, (i, j) -> i > j);
        }
    }

    public static int binarySearch(int[] arr, int key, int lo, int hi, java.util.function.BiFunction<Integer, Integer, Boolean> compare) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == key) {
            return mid;

        } else if (compare.apply(arr[mid], key)) {
            return binarySearch(arr, key, mid + 1, hi, compare);

        } else {
            return binarySearch(arr, key, lo, mid - 1, compare);
        }
    }

    public static void main(String[] args) {
        System.out.println(UnknownBinarySearch.search(new int[]{4, 6, 10}, 10));//2
        System.out.println(UnknownBinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));//4
        System.out.println(UnknownBinarySearch.search(new int[]{10, 6, 4}, 10));//0
        System.out.println(UnknownBinarySearch.search(new int[]{10, 6, 4}, 4));//2
    }
}
