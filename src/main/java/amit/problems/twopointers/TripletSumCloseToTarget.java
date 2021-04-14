package amit.problems.twopointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 */
public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));//1
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1)); //0
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));//3
    }

    public static int searchTriplet(int[] arr, int targetSum) {
        int[] min = new int[]{Integer.MAX_VALUE, 0};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int[] minLocal = searchTriplets(arr, targetSum - arr[i], i + 1, i);
            if (min[0] > minLocal[0]) {
                min[0] = minLocal[0];
                min[1] = minLocal[1];
            }
        }
        return min[1];
    }

    private static int[] searchTriplets(int[] arr, int target, int start, int first) {
        int[] min = new int[]{Integer.MAX_VALUE, 0};
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (min[0] > Math.abs(target - sum)) {
                min[0] = Math.abs(target - sum);
                min[1] = arr[first] + sum;
            }

            if (sum == target) {
                return min;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return min;
    }
}
