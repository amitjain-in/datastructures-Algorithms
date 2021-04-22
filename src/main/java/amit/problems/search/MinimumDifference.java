package amit.problems.search;

/**
 * Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
 */
public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return 0;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int result = arr[left];
        if (left - 1 >= 0) {
            if (Math.abs(arr[left - 1] - key) < Math.abs(result - key)) {
                result = arr[left - 1];
            }
        }
        if (left + 1 < arr.length) {
            if (Math.abs(arr[left + 1] - key) < Math.abs(result - key)) {
                result = arr[left + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 17));
    }
}
