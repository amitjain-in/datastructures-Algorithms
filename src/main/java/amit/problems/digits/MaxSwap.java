package amit.problems.digits;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * https://leetcode.com/problems/maximum-swap/
 */
public class MaxSwap {

    public static void main(String[] args) {
        MaxSwap maxSwap = new MaxSwap();
        System.out.println(maxSwap.maximumSwap(2736));
        System.out.println(maxSwap.maximumSwap(9973));
        System.out.println(maxSwap.maximumSwap(1993));
    }

    //Status: works
    public int maximumSwap(int num) {
        int[] digits = new int[getDigitCount(num)];
        getDigits(digits, num);

        for(int i = 0; i < digits.length; i++) {
            int maxDig = -1;
            int maxDigIdx = -1;
            for(int j = digits.length - 1; j >= i; j--) {
                if(digits[j] > maxDig) {
                    maxDig = Math.max(digits[j], maxDig);
                    maxDigIdx = j;
                }
            }
            if(maxDig != digits[i]) {
                int tmp = digits[maxDigIdx];
                digits[maxDigIdx] = digits[i];
                digits[i] = tmp;
                break;
            }
        }

        int tens = 1;
        num = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            num += digits[i] * tens;
            tens *= 10;
        }
        return num;
    }

    public static int getDigitCount(int num) {
        int digCount = 1;
        while ((num = num / 10) > 0) {
            digCount++;
        }
        return digCount;
    }

    public static void getDigits(int[] digits, int num) {

        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num = num / 10;
        }
    }
}
