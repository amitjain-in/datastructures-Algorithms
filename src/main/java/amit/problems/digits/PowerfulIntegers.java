package amit.problems.digits;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
 *
 * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
 *
 * You may return the answer in any order. In your answer, each value should occur at most once.
 *
 * https://leetcode.com/problems/powerful-integers/
 *
 * Status works
 */
public class PowerfulIntegers {

    public static void main(String[] args) {
        PowerfulIntegers powerfulIntegers = new PowerfulIntegers();
        System.out.println(powerfulIntegers.powerfulIntegers(2, 1, 10));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> finalResult = new HashSet<>();
        int result = 0;
        int xPower = 1;

        while (result <= bound) {
            int yPower = 1;
            result = xPower + yPower;

            while (result <= bound) {
                finalResult.add(result);
                if (y == 1) {
                    break;
                }
                yPower *= y;
                result = xPower + yPower;
            }

            if (x == 1) {
                break;
            }

            yPower = 1;
            xPower *= x;
            result = xPower + yPower;
        }

        return new LinkedList<>(finalResult);
    }

}
