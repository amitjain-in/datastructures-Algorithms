package amit.problems.arrays;

import java.util.Arrays;

/**
 * Constraints:
 * 1. Time complexity - o(n)
 * 2. Space complexity - o(n) including output array;
 * 3. Cannot use arithmetic division
 */
public class ArrayProductExceptItself {

    public static void main(String[] args) {
        solve(new int[]{1, 2, 3, 4});
        solve(new int[]{1, 2, -3, 4});
    }

    static void solve(int[] input) {

        System.out.println("input: " + Arrays.toString(input));

        int[] result = new int[input.length];
        result[0] = 1;//Identity multiplier
        int temp = input[0];//temp contains the product of numbers till i
        for (int i = 1; i < input.length; i++) {
            result[i] = temp;//result of i contains the product of numbers till 0 till i - 1;
            temp *= input[i];
        }
        temp = 1;
        for (int i = input.length - 1; i >= 0; i--) {//Now doing the same thing from reverse.
            result[i] = result[i] * temp;
            temp *= input[i];
        }

        System.out.println("output: " + Arrays.toString(result));
    }
}
