package amit.problems;

/**
 * Given an image (N x N) where each pixel is 4 bytes, rotate the image by 90  degrees. In place.
 * This should support square images
 */
public class ImageRotator {

    public static void main(String[] args) {
        //Instead of 4 bytes, we will be using integers (which are also 4 bytes in Java).
        int[][] picture = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(picture);
        int[][] picture1 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotate(picture1);
    }

    private static void rotate(int[][] picture) {
        printArray(picture);
        for (int i = 0; i < picture.length / 2; i++) {
            for (int j = i; j < picture.length - 1 - i; j++) {
                int temp = picture[i][j];
                picture[i][j] = picture[picture.length - 1 - j][i];
                picture[picture.length - 1 - j][i] = picture[picture.length - 1 - i][picture.length - 1 - j];
                picture[picture.length - 1 - i][picture.length - 1 - j] = picture[j][picture.length - 1 - i];
                picture[j][picture.length - 1 - i] = temp;
            }
        }
        printArray(picture);
    }

    private static void printArray(int[][] twoDArray) {
        System.out.println("*********************");
        for (int[] rows : twoDArray) {
            System.out.println();
            for (int ele : rows) {
                System.out.print(ele + " ");
            }
        }
        System.out.println("\n*********************");
    }
}
