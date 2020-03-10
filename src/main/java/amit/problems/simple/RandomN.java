package amit.problems.simple;

import java.util.Random;

/**
 * Write a method to generate a random number between 1 and 7,
 * given a method that generates a random number between 1 and 5 (i.e., implement rand7() using rand5()).
 */
public class RandomN {

    public static void main(String[] args) {

    }

    private static int rand5() {
        return new Random().nextInt(5);
    }

    private static int rand7() {
//        return rand5() + rand5();
        return 0;
    }
}
