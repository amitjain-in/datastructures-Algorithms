package amit.problems.digits;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 * <p>
 * If there is no such integer in the array, return 0.
 * <p>
 * https://leetcode.com/problems/four-divisors/
 * <p>
 * Status works but can be optimised with divisors generation by using map of already computed divisors.
 */
public class FourDivisors {

    public static void main(String[] args) {
        FourDivisors fourDivisors = new FourDivisors();
        System.out.println(fourDivisors.sumFourDivisors(new int[]{21, 4, 7}));
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            Set<Integer> divisors = getDivisors(num);
            if (divisors != null && divisors.size() == 4) {
                sum += divisors.stream().reduce(0, Integer::sum);
            }
        }
        return sum;
    }

    public Set<Integer> getDivisors(int num) {
        Set<Integer> divisors = new HashSet<>();
        divisors.add(num);
        divisors.add(1);
        int sqrt = (int) Math.sqrt(num);
        for (int i = sqrt; i > 1; i--) {
            if (num % i == 0) {
                if (divisors.size() < 4) {
                    divisors.add(i);
                    divisors.add(num / i);
                } else {
                    return null; //Do not bother
                }
            }
        }
        return divisors;
    }
}
