package amit.problems.arrays;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * Status Not working
 */
public class ShortestSubArraySumAtleastK {

    public static void main(String[] args) {
        ShortestSubArraySumAtleastK shortestSubArraySumAtleastK = new ShortestSubArraySumAtleastK();
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{1, 2}, 4)); // -1
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{1}, 1)); //1
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{2, -1, 2}, 3)); //3
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150)); //2
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167)); //3
        System.out.println(shortestSubArraySumAtleastK.shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89)); //3
    }

    public int shortestSubarray(int[] A, int K) {

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            while ((sum >= K || A[start] < 0) && start < i) {
                if (sum >= K) {
                    minLength = Math.min(i - start + 1, minLength);
                }
                sum -= A[start++];
            }
        }

        return minLength < Integer.MAX_VALUE ? minLength : -1;
    }
}
