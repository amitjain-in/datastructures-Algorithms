package amit.problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i; j < arr.length - 2; j++) {
                if (arr[j] == arr[i]) {
                    continue;
                }
                searchQuadruplesWithDuplicates(arr, target - (arr[i] + arr[j]), j + 1, quadruplets, arr[i], arr[j]);
            }
        }
        return quadruplets;
    }


    private static void searchQuadruplesWithDuplicates(int[] arr, int sum, int start, List<List<Integer>> triplets, int first, int second) {
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == sum) {
                triplets.add(Arrays.asList(first, second, arr[start], arr[end]));
                start++;
                end--;
                while (start < end && arr[start] == arr[start + 1]) {
                    start++;
                }
                while (start < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            } else if (arr[start] + arr[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
    }
}
