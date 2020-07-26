package amit.problems.strings;

public class InterleavingString {

    ///Doesn't work for case s1=aa s2=ab s3=aaba
    public boolean isInterleave(String s1, String s2, String s3) {
        int str1 = -1;
        int str2 = -1;
        int str3 = -1;

        while (++str3 < s3.length()) {
            char c = s3.charAt(str3);
            System.out.println("c=" + c);
            if ((str1 + 1) < s1.length() && s1.charAt(str1 + 1) == c && (str2 + 1) < s2.length() && s2.charAt(str2 + 1) == c) {
                System.out.println("str1=" + s1.charAt(str1 + 1) + " str2=" + s2.charAt(str2 + 1));
                //both are equal
                int oldStr1 = str1;
                int oldStr2 = str2;
                str1++;
                str2++;
                c = s3.charAt(++str3);
                while (((str1 + 1) < s1.length() && s1.charAt(str1 + 1) == c) || ((str2 + 1) < s2.length() && s2.charAt(str2 + 1) == c)) {
                    boolean firstMatches = false;
                    boolean secondMatches = false;
                    if ((str1 + 1) < s1.length() && s1.charAt(str1 + 1) == c) {
                        str1++;
                        firstMatches = true;
                    }
                    if ((str2 + 1) < s2.length() && s2.charAt(str2 + 1) == c) {
                        str2++;
                        secondMatches = true;
                    }
                    System.out.println("fm=" + firstMatches + " sm=" + secondMatches);
                    if (firstMatches && !secondMatches) {
                        str2 = oldStr2;
                        break;
                    } else if (!firstMatches && secondMatches) {
                        str1 = oldStr1;
                        break;
                    } else {
                        c = s3.charAt(++str3);
                    }
                }
            } else if ((str1 + 1) < s1.length() && s1.charAt(str1 + 1) == c) {
                System.out.println("str1=" + s1.charAt(str1 + 1));
                str1++;
            } else if ((str2 + 1) < s2.length() && s2.charAt(str2 + 1) == c) {
                System.out.println("str2=" + s2.charAt(str2 + 1));
                str2++;
            } else {
                return false;
            }
        }

        return (str1 + 1) >= s1.length() && (str2 + 1) >= s2.length();
    }
}
