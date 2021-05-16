package amit.problems.digits;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 * For this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    //Status works
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;

        long dividendL = Math.abs((long) dividend);//To handle division with Integer.MIN_VALUE
        long divisorL = Math.abs((long) divisor);
        if (dividendL < divisorL) {
            return 0;
        }

        long quotient = internalDivide(dividendL, divisorL);
        if ((sign > 0 && quotient > Integer.MAX_VALUE) || quotient < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == 1) {
            return (int) quotient;
        } else {
            return (int) -quotient;
        }
    }

    private long internalDivide(long dividend, long divisor) {

        if (dividend < divisor) {
            return 0;
        }

        long multiple = 1;
        long sum = divisor;
        while (sum + sum < dividend) {//Binary Search
            sum = sum + sum;
            multiple = multiple + multiple;
        }
        return multiple + internalDivide(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(10, 3));//3
        System.out.println(divideTwoIntegers.divide(7, -3));//-2
        System.out.println(divideTwoIntegers.divide(0, 1));//0
        System.out.println(divideTwoIntegers.divide(1, 1));//1
        System.out.println(divideTwoIntegers.divide(-1, 1));//1
        System.out.println(divideTwoIntegers.divide(Integer.MIN_VALUE, -1));//2147483647 [Edge Cases]
        System.out.println(divideTwoIntegers.divide(Integer.MIN_VALUE, 1));//-2147483648 [Edge Cases]
    }
}
