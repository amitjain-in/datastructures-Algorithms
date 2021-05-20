package amit.problems.digits;

/**
 *
 * Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.
 *
 * After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.
 *
 * https://leetcode.com/problems/sum-of-digits-in-base-k
 */
public class SumOfDigitsInBaseK {

    //Status Works
    public int sumBase(int n, int k) {
        int newNum = 0;
        while(n != 0) {
            newNum = newNum * 10 +  n % k;
            n = n/k;
        }

        return getDigitSum(newNum);
    }

    public int getDigitSum(int num) {
        int digSum = 0;
        while (num > 0) {
            digSum += num % 10;
            num = num / 10;
        }
        return digSum;
    }
}
