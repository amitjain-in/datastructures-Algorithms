package amit.problems.arrays;

public class RotateLeft {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int [] retArr = new int[a.length];
        d = d % a.length;
        for(int i = 0; i < a.length; i++) {
            retArr[(a.length + i - d) % (a.length)] = a[i];
        }
        return retArr;
    }
}
