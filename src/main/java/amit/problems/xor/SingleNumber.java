package amit.problems.xor;

/**
 * In a non-empty array of integers, every number appears twice except for one, find that single number.
 */
public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int x = 0;
        for (int j : arr) {
            x = x ^ j;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}