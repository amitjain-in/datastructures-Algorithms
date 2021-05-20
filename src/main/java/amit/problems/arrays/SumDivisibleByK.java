package amit.problems.arrays;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k
 * <p>
 * status not working
 */
public class SumDivisibleByK {

    public static void main(String[] args) {
        SumDivisibleByK sumDivisibleByK = new SumDivisibleByK();
        System.out.println(sumDivisibleByK.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    //o(n^2) - Correct but too slow
    public int subarraysDivByKBruteForce(int[] A, int K) {

        int sum;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    //o(n) - Works efficiently when K is small
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        int[] kSum = new int[K];
        kSum[0] = 1;

        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) {
                sum += K;
            }
            count += kSum[sum];
            kSum[sum]++;
        }
        return count;
    }

}
