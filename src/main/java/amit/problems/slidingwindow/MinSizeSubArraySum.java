package amit.problems.slidingwindow;


/**
 * From educative.io
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Pattern //sliding window
 *
 * Status works
 */
class MinSizeSubArraySum {

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));//2
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));//1
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));//3
    }

    public static int findMinSubArray(int S, int[] arr) {
        int sum = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= S && start < i) {
                if (sum >= S) {
                    minLen = Math.min(minLen, i - start);
                }
                sum -= arr[++start];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}