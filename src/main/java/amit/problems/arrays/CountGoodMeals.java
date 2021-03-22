package amit.problems.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 * <p>
 * You can pick any two different foods to make a good meal.
 * <p>
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the ith item of food,
 * return the number of different good meals you can make from this list modulo 109 + 7.
 * <p>
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 * <p>
 * https://leetcode.com/problems/count-good-meals/
 * <p>
 * Status: Working
 */
public class CountGoodMeals {

    public static void main(String[] args) {
        CountGoodMeals countGoodMeals = new CountGoodMeals();
        System.out.println(countGoodMeals.countPairs(new int[]{1, 3, 5, 7, 9}));//4
        System.out.println(countGoodMeals.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));//15
        System.out.println(countGoodMeals.countPairs(new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234}));//12
    }

    public int countPairs(int[] deliciousness) {
        int[] powersOf2 = new int[22];
        powersOf2[0] = 1;

        for (int i = 0; i <= 21; i++) {
            powersOf2[i] = (int) Math.pow(2, i);
        }

        int count = 0;

        Map<Integer, Integer> prevMap = new HashMap<>();

        for (int k : deliciousness) {
            for (int power : powersOf2) {
                Integer prev = prevMap.get(power - k);
                if (prev != null) {
                    count = (prev + count) % 1_000_000_007;
                }
            }
            prevMap.put(k, prevMap.getOrDefault(k, 0) + 1);
        }

        return count;
    }

}
