package amit.problems.dp;

/**
 * Delete at most one element from an array and find the max contiguous sub-array with at least one element.
 */
public class MaxSumWithOneDelete {

    public static void main(String[] args) {
        MaxSumWithOneDelete maxSumWithOneDelete = new MaxSumWithOneDelete();

        System.out.println(maxSumWithOneDelete.maximumSumSimple(new int[]{1, -2, 0, 3})); //4
        System.out.println(maxSumWithOneDelete.maximumSumSimple(new int[]{1, -2, -2, 3})); //3
        System.out.println(maxSumWithOneDelete.maximumSumSimple(new int[]{-1, -1, -1, -1})); //-1
        System.out.println(maxSumWithOneDelete.maximumSumSimple(new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6})); //17
    }

    public int maximumSum(int[] arr) {

        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);//Normal max sub array sum without deletion
            dp[i][1] = Math.max(arr[i], Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]));
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        return max;
    }

    //Not working for multiple negatives in the subarray
    public int maximumSumSimple(int[] arr) {

        int left = 0, right = 0;
        int negative = 0;
        int negativeValue = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (right < arr.length) {
            sum += arr[right];
            if (arr[right] < 0) {
                if (negative == 1) {//Cannot have more than two negatives
                    while (arr[left] >= 0 && left < right) {
                        sum -= arr[left++];
                    }
                    sum -= arr[left++];
                } else {
                    negative = 1;
                }
                negativeValue = arr[right];
            }
            if (right - left == 0) {
                max = Math.max(max, sum);
            } else {
                max = Math.max(max, sum - negativeValue);
            }
            right++;
        }

        return max;
    }
}
