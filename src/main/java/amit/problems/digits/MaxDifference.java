package amit.problems.digits;

/**
 *
 * You are given an integer num. You will apply the following steps exactly two times:
 *
 *     Pick a digit x (0 <= x <= 9).
 *     Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
 *     Replace all the occurrences of x in the decimal representation of num by y.
 *     The new integer cannot have any leading zeros, also the new integer cannot be 0.
 *
 * Let a and b be the results of applying the operations to num the first and second times, respectively.
 *
 * Return the max difference between a and b.
 *
 *
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 *
 * Status works
 */
public class MaxDifference {

    public int maxDiff(int num) {
        //first replacement - maximise the num - find first digit if it is != 9 then replace with 9 else second and so on.
        //second replacement - minimise the num - find first digit if its != 1 then replace with 1 else replace second with 0;
        int [] digits = digits(num);
        return replaceFirst(digits) - replaceSecond(digits);
    }

    private int replaceSecond(int[] num) {
        int replace = 11;
        int replaceWith = 0;

        if(num[num.length - 1] != 1) {
            replace = num[num.length - 1];
            num[num.length - 1] = 1;
            replaceWith = 1;
        } else {
            boolean onlyHas1 = true;
            for (int j : num) {
                if (j != 1) {
                    onlyHas1 = false;
                    break;
                }
            }
            if(onlyHas1) {
                replace = 1;
                replaceWith = 1;
            }
        }
        int newNum = Math.min(replace, num[num.length - 1]);
        for(int i = num.length - 2; i >= 0; i--) {
            if(replace == 11 && num[i] != 1 && num[i] != 0) {
                replace = num[i];
                newNum = newNum * 10;
                replaceWith = 0;
            } else if(num[i] == replace) {
                newNum = newNum * 10 + replaceWith;
            } else {
                newNum = newNum * 10 + num[i];
            }
        }
        return newNum;
    }

    public int replaceFirst(int[] num) {
        int replace = -1;
        int newNum = 0;
        for(int i = num.length - 1; i >= 0; i--) {
            if(num[i] != 9 && replace == -1) {
                replace = num[i];
                newNum = newNum * 10 + 9;
            } else if(num[i] == replace) {
                newNum = newNum * 10 + 9;
            } else {
                newNum = newNum * 10 + num[i];
            }
        }
        return newNum;
    }

    public int[] digits(int num) {
        int[] arr = new int[12];
        int i = 0;
        while(num > 0) {
            arr[i++] = num % 10;
            num = num / 10;
        }
        int[] ret = new int[i];
        System.arraycopy(arr, 0, ret, 0, i);
        return ret;
    }

    public static void main(String[] args) {
        MaxDifference maxDifference = new MaxDifference();
        System.out.println(maxDifference.maxDiff(555));//888
        System.out.println(maxDifference.maxDiff(9));//8
        System.out.println(maxDifference.maxDiff(123456));//8200000
        System.out.println(maxDifference.maxDiff(10000));//80000
        System.out.println(maxDifference.maxDiff(9288));//8700
        System.out.println(maxDifference.maxDiff(111));//888
        System.out.println(maxDifference.maxDiff(1101057));//8808050
        System.out.println(maxDifference.maxDiff(9089733));//8918000
    }
}
