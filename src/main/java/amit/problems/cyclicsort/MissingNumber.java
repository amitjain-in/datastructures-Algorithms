package amit.problems.cyclicsort;

import java.util.Arrays;

/**
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number
 */
public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        return ((nums.length * (nums.length + 1)) / 2) -  Arrays.stream(nums).sum();
    }
}
