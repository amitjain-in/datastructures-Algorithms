package amit.problems.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer 'n', create an array such that each value is repeated twice. For example.
 * n = 3 --> [1,1,2,2,3,3]
 * n = 4 --> [1,1,2,2,3,3,4,4]
 * After creating it, find a permutation such that each number is spaced in such a way, they are at a "their value" distance from the second occurrence of the same number.
 * For example: n = 3 --> This is the array - [1,1,2,2,3,3].
 * Your output should be [3,1,2,1,3,2].
 * The second 3 is 3 digits away from the first 3.
 * The second 2 is 2 digits away from the first 2.
 * The second 1 is 1 digit away from the first 1.
 * Return any 1 permutation if it exists. Empty array if no permutation exists.
 * Follow up: Return all possible permutations.
 */
public class EquidistantNumberArray {

    public static void main(String[] args) {

        for (int i = 3; i < 20; i++) {
            printResult(generateBackTrack(i), i);//Very slow for n > 12 and no combinations are possible for that n
        }
    }

    //Constraints: n > 0
    static List<int[]> generateBackTrack(int n) {
        long startTs = System.currentTimeMillis();
        List<int[]> results = new LinkedList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] array = new int[n * 2];
            array[i] = n;
            array[i + n + 1] = n;
            boolean isValid = prunedBackTrack(array, n - 1, i == 0 ? i + 1 : 0, array.length - n - 1);
            if (isValid) {
                results.add(array);
            }
        }
        System.out.println(System.currentTimeMillis() - startTs + " ms for n=" + n);
        return results;
    }

    static boolean prunedBackTrack(int[] array, int num, int from, int to) {
        for (int i = from; i <= to; i++) {
            int other = i + num + 1;
            if (array[i] == 0 && array[other] == 0) {
                array[i] = num;
                array[other] = num;
                if (num > 1) {
                    boolean isValid = prunedBackTrack(array, num - 1, i == from ? i + 1 : from, array.length - num - 1);
                    if (!isValid) {
                        array[i] = 0;
                        array[other] = 0;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printResult(List<int[]> results, int n) {
        System.out.println("Input: n = " + n);
        System.out.println("Output:");
        for (int[] arr : results) {
            System.out.println("" + Arrays.toString(arr));
        }
        System.out.println();
    }
}
