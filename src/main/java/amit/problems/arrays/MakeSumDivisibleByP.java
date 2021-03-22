package amit.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p.
 * It is not allowed to remove the whole array.
 * <p>
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 * <p>
 * A subarray is defined as a contiguous block of elements in the array.
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 *
 * Status: working
 */
public class MakeSumDivisibleByP {

    public static void main(String[] args) {
        MakeSumDivisibleByP makeSumDivisibleByP = new MakeSumDivisibleByP();
        System.out.println(makeSumDivisibleByP.minSubarray(new int[]{3, 1, 4, 2}, 6)); //1
        System.out.println(makeSumDivisibleByP.minSubarray(new int[]{6, 3, 5, 2}, 9)); //2
        System.out.println(makeSumDivisibleByP.minSubarray(new int[]{1, 2, 3}, 3)); //0
        System.out.println(makeSumDivisibleByP.minSubarray(new int[]{1, 2, 3}, 7)); //-1
        System.out.println(makeSumDivisibleByP.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3)); //0
    }


    public int minSubarray(int[] nums, int p) {
        int len = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }

        map.put(0, -1);
        int moduloSum = 0;
        for (int i = 0; i < nums.length; i++) {
            moduloSum = (moduloSum + nums[i]) % p;
            map.put(moduloSum, i);
            int stillRemain = (moduloSum - remainder + p) % p;//'+ p' is to get around negative 'moduloSum - remainder'
            Integer foundRemains = map.get(stillRemain);
            if (foundRemains != null) {
                len = Math.min(len, i - foundRemains);
            }
        }

        return len == Integer.MAX_VALUE || len == nums.length ? -1 : len;
    }
}
