package amit.problems.digits;

public class SplitString {

    public boolean splitString(String s) {
        s = s.replaceAll("^0*", "");
        for (int split = 1; split <= s.length() / 2; split++) {
            boolean isValidSplit = isValidSplit(s.substring(split), Integer.parseInt(s.substring(0, split)));
            if (isValidSplit) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidSplit(String s, int number) {
        s = s.replaceAll("^0*", "");
        if (s.length() == 0) {
            return true;
        }
        for (int split = 1; split <= s.length(); split++) {
            int curr = Integer.parseInt(s.substring(0, split));
            if (number == curr + 1) {
                boolean isValidSplit = isValidSplit(s.substring(split), curr);
                if (isValidSplit) {
                    return true;
                }
            } else if (number < curr) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitString splitString = new SplitString();
        System.out.println(splitString.splitString("1098765432"));
        System.out.println(splitString.splitString("4771447713"));
        System.out.println(splitString.splitString("64424509442147483647"));//Not working - Integer overflow while parsing.

    }
}
