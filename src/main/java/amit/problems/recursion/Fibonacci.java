package amit.problems.recursion;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int tillN = 100;
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 1; i < tillN; i++) {
            long startTs = System.nanoTime();
            long sim = fibonacci.generate(i);
            double simNano = (System.nanoTime() - startTs) / 1000.0;
            startTs = System.nanoTime();
            long dp = fibonacci.generateWithDP(i, fibonacci.generateBlankDP(i));
            double dpNano = (System.nanoTime() - startTs) / 1000.0;
            startTs = System.nanoTime();
            long bd = fibonacci.generateBottomDownWithoutTable(i);
            double bdNano = (System.nanoTime() - startTs) / 1000.0;
            System.out.println(i + " -- Recursive: " + sim + " " + simNano + " us, TopDown: " + dp + " " + dpNano + " us, bottomDownWithoutTable: " + bd + " " + bdNano + " us");
        }
    }

    private long generate(int n) {
        return n == 0 || n == 1 ? n : generate(n - 1) + generate(n - 2);
    }

    private long generateWithDP(int n, long[] dp) {
        if (n > 2) {
            if (dp[n] != Long.MIN_VALUE) {
                return dp[n];
            }
        }

        long fib = n == 0 || n == 1 ? n : generateWithDP(n - 1, dp) + generateWithDP(n - 2, dp);
        dp[n] = fib;
        return fib;
    }

    private long[] generateBlankDP(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        return dp;
    }

    private long generateBottomDownWithoutTable(int n) {
        long n2 = 0;
        long n1 = 1;
        long fib = n1 + n2;

        for (int i = 2; i <= n; i++) {
            fib = n1 + n2;
            n2 = n1;
            n1 = fib;
        }
        return fib;
    }
}
