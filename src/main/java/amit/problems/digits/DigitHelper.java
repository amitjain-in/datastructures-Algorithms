package amit.problems.digits;

public class DigitHelper {

    /**
     * Given a num greater than 0, count of all the digits in the number
     *
     * @param num - The number > 0
     * @return - The count of all digits
     */
    public static int getDigitCount(int num) {
        int digCount = 1;
        while ((num = num / 10) > 0) {
            digCount++;
        }
        return digCount;
    }


    /**
     * Given a num greater than 0 sum all the digits in the number and return
     *
     * @param num - The number > 0
     * @return - The sum of digits
     */
    public static int getDigitSum(int num) {
        int digSum = 0;
        while (num > 0) {
            digSum += num % 10;
            num = num / 10;
        }
        return digSum;
    }
}
