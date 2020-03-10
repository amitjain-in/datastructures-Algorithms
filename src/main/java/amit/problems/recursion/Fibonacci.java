package amit.problems.recursion;

// Doesn't support if the number goes beyond Integer.MAX
public class Fibonacci {

    public static void main(String[] args) {
        int tillN = 100;
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 1; i < tillN; i++) {
            long startTs = System.nanoTime();
            long sim = fibonacci.generate(i);
            long simNano = System.nanoTime() - startTs;
            startTs = System.nanoTime();
            long dp = fibonacci.generateWithDP(i, fibonacci.generateBlankDP(i));
            long dpNano = System.nanoTime() - startTs;
            System.out.println(i + " -- " + sim + " " + simNano + " ns " + dp + " " + dpNano + " ns");
        }
    }

    private long generate(int n) {
        return n == 0 || n == 1 ? n : generate(n - 1) + generate(n - 2);
    }

    private long generateWithDP(int n, long[][] dp) {
        if(n > 2) {
            if (dp[n - 1][0] != Long.MIN_VALUE) {
                return dp[n - 1][0];
            }
        }

        long fib = n == 0 || n == 1 ? n : generate(n - 1) + generate(n - 2);
        dp[n - 1][0] = fib;
        return fib;
    }

    private long[][] generateBlankDP(int n) {
        long[][] dp = new long[n][1];
        for(int i=0;i < n; i++) {
            dp[i][0] = Long.MIN_VALUE;
        }
        return dp;
    }
}
