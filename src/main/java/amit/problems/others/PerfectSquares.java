package amit.problems.others;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquaresNew(13));
        System.out.println(ps.numSquaresNew(12));
      //  System.out.println(ps.numSquares(55));
        System.out.println(ps.numSquaresNew(55));
    }

    //This is very slow.
    public int numSquares(int n) {
        if (n <= 1) {
            return Math.max(0, n);
        }
        int maxSquare = findMaxSquare(n);
        int minNum = Integer.MAX_VALUE;
        int currNum = 0;
        int sum = n;
        for (int i = maxSquare; i > 0; i--) {
            sum -= i * i;
            currNum++;
            if (sum >= 0) {
                currNum += numSquares(sum);
                minNum = Math.min(minNum, currNum);
            }
            sum = n;
            currNum = 0;
        }

        return minNum;
    }

    int findMaxSquare(int n) {
        int i = 0;
        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }


    public int numSquaresNew(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int square = 1; square * square <= i; square++) {
                dp[i] = Math.min(dp[i], dp[i - square * square] + 1);
            }
        }
        return dp[n];
    }
}
