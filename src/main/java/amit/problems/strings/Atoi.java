package amit.problems.strings;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/string-to-integer-atoi
 */
public class Atoi {

    //Cleared all testcases in Leetcode
    public int myAtoi(String str) {
        String trimmed = str.trim();
        if (trimmed.length() > 0) {
            boolean isNegative = trimmed.charAt(0) == '-';
            boolean isPositive = trimmed.charAt(0) == '+';
            List<Long> nums = new LinkedList<>();
            for (int i = (isNegative || isPositive) ? 1 : 0; i < trimmed.length(); i++) {
                char c = trimmed.charAt(i);
                Long num = getNum(c);
                if (num != null) {
                    nums.add(num);
                } else {
                    if (nums.size() == 0) {
                        return 0;
                    }
                    break;
                }
            }
            int tens = nums.size();
            long number = 0L;
            for (Long num : nums) {
                number += (long) (Math.pow(10, --tens) * num);
                if (!isNegative && number > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (isNegative && number > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            number = isNegative ? -1 * number : number;
            if (number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (number < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) number;
            }
        }
        return 0;
    }

    static Long getNum(char c) {
        return c >= '0' && c <= '9' ? (long) (c - '0') : null;
    }
}
