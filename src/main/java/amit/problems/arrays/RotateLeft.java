package amit.problems.arrays;

import java.util.Arrays;

public class RotateLeft {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3}, 1)));

        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3}, 2)));
        System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3}, 2)));
    }

    static int[] rotateLeft(int[] a, int d) {
        int [] retArr = new int[a.length];
        d = d % a.length;
        for(int i = 0; i < a.length; i++) {
            retArr[(a.length + i - d) % (a.length)] = a[i];
        }
        return retArr;
    }

    static int[] rotateRight(int[] a, int d) {
        int [] retArr = new int[a.length];
        d = d % a.length;
        for(int i = 0; i < a.length; i++) {
            retArr[(a.length + i + d) % (a.length)] = a[i];
        }
        return retArr;
    }
}
