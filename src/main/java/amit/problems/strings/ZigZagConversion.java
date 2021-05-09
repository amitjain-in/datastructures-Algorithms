package amit.problems.strings;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    //Solution taken from https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {

            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);

            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up starting from top.
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
