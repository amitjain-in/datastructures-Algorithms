package amit.problems.arrays;

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 *
 * Status: Not working
 */
public class SumOfSubArrayMinimums {

    public static void main(String[] args) {
        SumOfSubArrayMinimums sumOfSubArrayMinimums = new SumOfSubArrayMinimums();
        System.out.println(sumOfSubArrayMinimums.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] arr) {
        int minSum = 0;
        int[] dp = new int[arr.length + 1];

        for(int i = 0; i < arr.length; i++) {

        }
        return minSum;
    }
}
