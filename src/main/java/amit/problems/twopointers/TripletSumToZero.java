package amit.problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            searchTriplets(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchTriplets(int[] arr, int i, int start, List<List<Integer>> triplets) {
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == i) {
                triplets.add(Arrays.asList(-i, arr[start], arr[end]));
                start++;
                end--;
            } else if (arr[start] + arr[end] < i) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static List<List<Integer>> searchTripletsWithDuplicates(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchTripletsWithDuplicates(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchTripletsWithDuplicates(int[] arr, int i, int start, List<List<Integer>> triplets) {
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == i) {
                triplets.add(Arrays.asList(-i, arr[start], arr[end]));
                start++;
                end--;
                while (start < end && arr[start] == arr[start + 1]) {
                    start++;
                }
                while (start < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            } else if (arr[start] + arr[end] < i) {
                start++;
            } else {
                end--;
            }
        }
    }
}
