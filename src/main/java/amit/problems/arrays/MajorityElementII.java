package amit.problems.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 * https://leetcode.com/problems/majority-element-ii/
 *
 * Status works
 */
public class MajorityElementII {

    //This can be solved using Boyer Moore voting algorithm in O(1) Space complexity
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> results = new LinkedList<>();
        for(Map.Entry<Integer, Integer> kv: countMap.entrySet()) {
            if(kv.getValue() >= nums.length / 3) {
                results.add(kv.getKey());
            }
        }

        return results;
    }
}
