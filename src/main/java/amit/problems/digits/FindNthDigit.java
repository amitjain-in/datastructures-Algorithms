package amit.problems.digits;

/**
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * <p>
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * 1 <= n <= 2^31
 * https://leetcode.com/problems/nth-digit/
 */
public class FindNthDigit {

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(11));
        System.out.println(findNthDigit.findNthDigit(4444));
    }

    public int digits(int n) {
        int count = 0;
        int tens = 1;
        for (int i = 1; count < n; i++) {
            count += i * 9 * tens;
            tens *= 10;
        }
        return count;
    }

    public int findNthDigit(int n) {
        int upper = digits(n);
        return 0;
    }
}
