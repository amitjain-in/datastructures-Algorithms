package amit.problems.dp;

/**
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * <p>
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * <p>
 * <p>
 * <p>
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
 * Output the minimum number of steps to get n 'A'.
 *
 * Status: works
 */
public class TwoKeysKeyboard {

    public static void main(String[] args) {
        TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
        for (int i = 1; i <= 100; i++) {
            System.out.println("i = " + i + " minSteps = " + twoKeysKeyboard.minSteps(i));
        }
    }

    public int minSteps(int n) {
        int[] steps = new int[n + 1];

        steps[0] = 0;
        steps[1] = 0;

        for (int i = 2; i <= n; i++) {
            steps[i] = i;//Assume something is pasted with single element;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) { //if a n is a factor of a lower number then we can just paste that many (j) elements i/j times to get the fastest result.
                    steps[i] = steps[j] + i / j;
                    break;
                }
            }
        }

        return steps[n];
    }
}
