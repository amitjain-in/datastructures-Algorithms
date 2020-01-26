package amit.problems.strings;

public class RotationCheck {
    public static void main(String[] args) {
        System.out.println(checkRotation("waterbottle", "erbottlewat"));
        System.out.println(checkRotation("waterbottle", "bottlewat"));
    }

    /**
     * Assume you have a method isSubstring which checks if one word is a substring of another.
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
     */
    private static boolean checkRotation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String newSw = s1 + s1;
        System.out.println(s1 + "," + s2);
        return isSubstring(newSw, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
