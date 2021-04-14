package amit.problems.twopointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 */
public class TripletWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int end = arr.length - 1;

            while (left < end) {
                int sum = arr[left] + arr[end];
                if (sum < target - arr[i]) {
                    count += end - left;
                    left++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
