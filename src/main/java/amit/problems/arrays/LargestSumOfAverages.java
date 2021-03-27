package amit.problems.arrays;

public class LargestSumOfAverages {

    public static void main(String[] args) {
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        System.out.println(largestSumOfAverages.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }

    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length + 1][K + 1];

        double runSum = 0;
        for (int i = 0; i < A.length; i++) {
            runSum += A[i];
            dp[i][1] = runSum / (i + 1);
        }

        return findOptimalAverage(A.length, K, A, dp);
    }

    double findOptimalAverage(int n, int k, int[] A, double[][] dp) {

        if (dp[n][k] > 0) {//Memoization
            return dp[n][k];
        }

        if (n < k) {//Array length is smaller than total partitions required, hence not possible
            return 0;
        }

        double runSum = 0;

        for (int i = n - 1; i > 0; --i) {
            runSum += A[i];
            dp[n][k] = Math.max(dp[n][k], findOptimalAverage(i, k - 1, A, dp) + runSum / (n - i));
        }
        return dp[n][k];
    }


    //Taken from leetcode solutions
    public double largestSumOfAveragesFromLeetCodeSolution(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        for (int k = 0; k < K-1; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = i+1; j < N; ++j)
                    dp[i] = Math.max(dp[i], (P[j]-P[i]) / (j-i) + dp[j]);

        return dp[0];
    }
}
