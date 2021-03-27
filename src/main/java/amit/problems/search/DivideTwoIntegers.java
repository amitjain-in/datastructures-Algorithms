package amit.problems.search;

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

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(Integer.MIN_VALUE, -1)); //
        System.out.println(divideTwoIntegers.divide(7, -1)); //-7
        System.out.println(divideTwoIntegers.divide(10, 2)); //5
        System.out.println(divideTwoIntegers.divide(10, 3)); //3
        System.out.println(divideTwoIntegers.divide(-10, 3)); //-3
        System.out.println(divideTwoIntegers.divide(0, 1)); //0
        System.out.println(divideTwoIntegers.divide(0, -1)); //0
    }

    public int divide(int dividend, int divisor) {
        int quotient = 0;
        int goal = 0;
        boolean isNegative = (dividend >= 0 && divisor < 0) || (dividend < 0 && divisor >= 0);
        dividend = isNegative ? Math.abs(dividend) : dividend;
        divisor = isNegative ? Math.abs(divisor) : divisor;

        while ((dividend > 0 && goal <= dividend && goal < Integer.MAX_VALUE) || (dividend < 0 && goal >= dividend && goal > Integer.MIN_VALUE)) {
            quotient++;
            goal += divisor;
            if ((dividend > 0 && goal < dividend) || (dividend < 0 && goal > dividend)) {
                goal = goal + goal;
                quotient = quotient + quotient;
            }
        }

        return dividend == 0 ? 0 : (isNegative ? -1 : 1) * (quotient - 1);
    }
}
