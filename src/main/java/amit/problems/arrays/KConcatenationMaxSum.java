package amit.problems.arrays;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class KConcatenationMaxSum {


    public static void main(String[] args) {
        KConcatenationMaxSum k = new KConcatenationMaxSum();
        System.out.println(k.optimised(new int[]{-5,-2,0,0,3,9,-2,-5,4}, 5));
    }

    //but not clean
    public int optimised(int[] arr, int k) {
        long maxSum = 0;
        long curSum = 0;

        for (int item : arr) {
            curSum += item;
            if (curSum > maxSum) {
                maxSum = curSum;
            } else if (curSum < 0) {
                curSum = 0;
            }
        }

        if (k > 1) {
            long firstMaxSum = maxSum;
            long neg = 0;
            long pos = 0;
            for (int value : arr) {
                neg += Math.min(value, 0);
                pos += Math.max(value, 0);
                curSum += value;
                if (curSum > maxSum) {
                    maxSum = curSum;
                } else if (curSum < 0) {
                    curSum = 0;
                }
            }
            if (maxSum > firstMaxSum && neg * -1 < pos) {
                long delta = maxSum - firstMaxSum;
                maxSum += Math.max(k - 2, 0) * delta;
            }
        }
        return maxSum <= 0 ? 0 : (int) (maxSum % (1000000007));
    }

    //o(n * k)
    public int naive(int[] arr, int k) {
        long maxSum = 0;
        long curSum = 0;

        for (int j = 0; j < k; j++) {
            for (int value : arr) {
                curSum += value;
                if (curSum > maxSum) {
                    maxSum = curSum;
                } else if (curSum < 0) {
                    curSum = 0;
                }
            }
        }
        return maxSum <= 0 ? 0 : (int) (maxSum % (1000000007));
    }

    //Scenarios
    //1. [-12,-1,-4,11,-8,6,9,-5,-7,7,12,10]
    //10
}
