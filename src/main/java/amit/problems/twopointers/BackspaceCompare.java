package amit.problems.twopointers;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
    }

    public static boolean compare(String str1, String str2) {

        int s1 = str1.length() - 1;
        int s2 = str2.length() - 1;

        while (s1 >= 0 && s2 >= 0) {
            int bs1 = 0;
            while (s1 >= 0 && str1.charAt(s1) == '#') {
                bs1++;
                s1--;
            }
            s1 -= bs1;
            int bs2 = 0;
            while (s2 >= 0 && str2.charAt(s2) == '#') {
                bs2++;
                s2--;
            }
            s2 -= bs2;
            if (s1 >= 0 && s2 >= 0) {
                if (str1.charAt(s1) != str2.charAt(s2)) {
                    return false;
                }
            } else if (s1 >= 0 || s2 >= 0) {
                return false;
            }
            s1--;
            s2--;
        }

        return s1 < 0 && s2 < 0;
    }
}