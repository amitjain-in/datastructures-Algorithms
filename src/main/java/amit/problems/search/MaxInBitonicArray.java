package amit.problems.search;

/**
 * Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1]
 */
public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[]{1, 3, 8, 12, 4, 2}));//12
        System.out.println(MaxInBitonicArray.findMax(new int[]{3, 8, 3, 1}));//8
        System.out.println(MaxInBitonicArray.findMax(new int[]{1, 3, 8, 12}));//12
        System.out.println(MaxInBitonicArray.findMax(new int[]{10, 9, 8}));//10
    }
}
