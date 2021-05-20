package amit.problems.digits;

public class MultiplyStrings {

    //fails for integer overflow
    public String multiply(String num1, String num2) {
        int finalResult = 0;
        int multiple = 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c1 = num2.charAt(i);
            int carry = 0;
            int result = 0;
            int tens = 1;
            for (int j = num1.length() - 1; j >= 0; j--) {
                char c2 = num1.charAt(j);
                int product = (c1 - '0') * (c2 - '0') + carry;
                result += tens * (product % 10);
                carry = product / 10;
                tens *= 10;
            }
            finalResult += (carry * tens + result) * multiple;
            multiple *= 10;
        }

        return String.valueOf(finalResult);
    }

    //Reference -> https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    public String multiplyFromLeetcode(String num1, String num2) {
        //Works for all cases and any length of strings.
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];//Most significant digit will be at the start of the array.

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int curr = i + j, next = i + j + 1;
                int sum = mul + pos[next];

                pos[curr] += sum / 10;
                pos[next] = sum % 10;//Carry for next multiple
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (sb.length() == 0 && p == 0) {
                continue;
            }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
//        System.out.println(multiplyStrings.multiply("9", "99"));
//        System.out.println(multiplyStrings.multiply("9", "98"));
//        System.out.println(multiplyStrings.multiply("98", "9"));
//        System.out.println(multiplyStrings.multiply("9", "9"));
        System.out.println(multiplyStrings.multiplyFromLeetcode("2", "3"));
        System.out.println(multiplyStrings.multiplyFromLeetcode("12", "2"));
//        System.out.println(multiplyStrings.multiply("2", "0"));
//        System.out.println(multiplyStrings.multiply("0", "2"));
//        System.out.println(multiplyStrings.multiply("5", "1"));
//        System.out.println(multiplyStrings.multiply("1", "5"));
//        System.out.println(multiplyStrings.multiply("1", "5"));
//        System.out.println(multiplyStrings.multiply("123", "456"));
    }
}
