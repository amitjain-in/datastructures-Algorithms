package amit.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:
 * <p>
 * Add a positive integer to an element of a given index in the array nums2.
 * Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
 * <p>
 * Implement the FindSumPairs class:
 * <p>
 * FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
 * void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
 * int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 * <p>
 * https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
 *  *
 * Status works
 */
public class FindSumPairs {

    private final Map<Integer, Integer> nums1Map = new HashMap<>();
    private final Map<Integer, Integer> nums2Map = new HashMap<>();
    private int[] nums2 = null;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        //Add all values of both arrays in their respective maps and increment their count
        for (int num : nums1) {
            nums1Map.merge(num, 1, Integer::sum);
        }
        for (int num : nums2) {
            nums2Map.merge(num, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        int oldValue = nums2Map.get(nums2[index]);
        //Adjust old num2 counters
        if (oldValue == 1) {
            //Either remove it if this was last
            nums2Map.remove(nums2[index]);
        } else {
            //Or decrement
            nums2Map.put(nums2[index], oldValue - 1);
        }
        nums2[index] += val;
        nums2Map.merge(nums2[index], 1, Integer::sum);//Now merge the new value at this index into the array.
    }

    public int count(int tot) {
        int count = 0;
        //Because according to the input constraints nums1 has lesser number of values hence iterate over that.
        for (Map.Entry<Integer, Integer> num1Entry : nums1Map.entrySet()) {
            int findInNum2 = tot - num1Entry.getKey();
            int num2 = nums2Map.getOrDefault(findInNum2, 0);
            count += num1Entry.getValue() * num2;
        }
        return count;
    }
}

