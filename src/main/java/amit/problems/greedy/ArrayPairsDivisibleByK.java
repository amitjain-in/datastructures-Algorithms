package amit.problems.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return True If you can find a way to do that or False otherwise.
 *
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 */
public class ArrayPairsDivisibleByK {

    public static void main(String[] args) {
        ArrayPairsDivisibleByK arrayPairsDivisibleByK = new ArrayPairsDivisibleByK();
        System.out.println(arrayPairsDivisibleByK.canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));//true
        System.out.println(arrayPairsDivisibleByK.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7)); //true
        System.out.println(arrayPairsDivisibleByK.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10)); //false
        System.out.println(arrayPairsDivisibleByK.canArrange(new int[]{-10, 10}, 2)); //true
        System.out.println(arrayPairsDivisibleByK.canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3)); //true
    }

    //Status: works
    public boolean canArrange(int[] arr, int k) {

        Map<Integer, Integer> modMap = new HashMap<>();
        for (int elem : arr) {
            int mod = elem % k < 0 ? elem % k + k : elem % k;
            int pair = (k - mod) % k;
            Integer found = modMap.get(pair);
            if (found != null) {
                found--;
                if (found == 0) {
                    modMap.remove(pair);
                } else {
                    modMap.put(pair, found);
                }
            } else {
                int val = modMap.getOrDefault(mod, 0);
                modMap.put(mod, val + 1);
            }
        }
        return modMap.isEmpty();
    }
}
