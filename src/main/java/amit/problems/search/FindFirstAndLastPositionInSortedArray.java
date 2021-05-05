package amit.problems.search;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionInSortedArray {


    //Status: works
    public int[] searchRange(int[] nums, int target) {
        int idx = binarySearch(nums, 0, nums.length - 1, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{binarySearchLeft(nums, target, 0, idx), binarySearchRight(nums, target, idx, nums.length - 1)};
        }
    }

    //Status: also works in only two binary searches
    public int[] searchRange2(int[] nums, int target) {
        int left = binarySearchLeft(nums, target, 0, nums.length - 1);
        int right = binarySearchRight(nums, target, 0, nums.length - 1);
        if (left > right) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right};
        }
    }

    static int binarySearch(int[] nums, int start, int end, int target) {
        if (start < end) {
            int midIdx = start + (end - start) / 2;
            int mid = nums[midIdx];
            if (mid > target) {
                return binarySearch(nums, start, midIdx - 1, target);
            } else if (mid < target) {
                return binarySearch(nums, midIdx + 1, end, target);
            } else {
                return midIdx;
            }
        } else {
            if (start == end && nums[start] == target) {
                return start;
            }
        }
        return -1;
    }


    //Modified binary search where we have removed the equality condition and let the search fail till start > end.
    //At this moment we have founded the upper bound or the lower bound of the element to be searched.
    int binarySearchRight(int[] array, int key, int start, int end) {
        if (start > end) {
            return end;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] > key) {
            return binarySearchRight(array, key, start, midIdx - 1);
        } else {
            return binarySearchRight(array, key, midIdx + 1, end);
        }
    }

    int binarySearchLeft(int[] array, int key, int start, int end) {
        if (start > end) {
            return start;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] < key) {
            return binarySearchLeft(array, key, midIdx + 1, end);
        } else {
            return binarySearchLeft(array, key, start, midIdx - 1);
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionInSortedArray findBounds = new FindFirstAndLastPositionInSortedArray();
        System.out.println(Arrays.toString(findBounds.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8)));//[3,4]
        System.out.println(Arrays.toString(findBounds.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6)));//[-1,-1]
        System.out.println(Arrays.toString(findBounds.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 5)));//[0, 0]
        System.out.println(Arrays.toString(findBounds.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 10)));//[5, 5]
        System.out.println(Arrays.toString(findBounds.searchRange2(new int[]{}, 0)));//[-1, -1]

        System.out.println(Arrays.toString(findBounds.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));//[3,4]
        System.out.println(Arrays.toString(findBounds.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));//[-1,-1]
        System.out.println(Arrays.toString(findBounds.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));//[0, 0]
        System.out.println(Arrays.toString(findBounds.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)));//[5, 5]
        System.out.println(Arrays.toString(findBounds.searchRange(new int[]{}, 0)));//[-1, -1]
    }
}
