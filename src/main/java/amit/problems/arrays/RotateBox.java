package amit.problems.arrays;

/**
 * You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
 *
 *     A stone '#'
 *     A stationary obstacle '*'
 *     Empty '.'
 *
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity.
 * Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions,
 * and the inertia from the box's rotation does not affect the stones' horizontal positions.
 *
 * It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
 *
 * Return an n x m matrix representing the box after the rotation described above.
 *
 * https://leetcode.com/problems/rotating-the-box/
 */
public class RotateBox {

    public char[][] rotateTheBox(char[][] box) {
        //Step 1 rotate
        //Help here
        // * Orig indices
        // 0,0  0,1  0,2
        // 1,0  1,1  1,2
        // 2,0  2,1  2,2
        //
        // 90 degree clock wise rotated indices
        // 2,0  1,0  0,0
        // 2,1  1,1  0,1
        // 2,2  1,2  0,2
        //
        char[][] result = new char[box[0].length][box.length];
        for (int row = 0; row < box.length; row++) {
            for (int col = 0; col < box[0].length; col++) {
                result[col][box.length - 1 - row] = box[row][col];
            }
        }


        //Drop the stones
        for (int col = 0; col < result[0].length; col++) {

            int lastObstacle = result.length;
            for (int row = result.length - 1; row >= 0; row--) {

                switch (result[row][col]) {

                    case '*': //Obstacle
                        lastObstacle = row;
                        break;

                    case '#': //Stone
                        if (lastObstacle > row + 1) {//Stone can be dropped
                            result[row][col] = '.';
                            result[--lastObstacle][col] = '#';
                        } else {//Stone cannot be dropped. Hence make this stone as the new obstacle.
                            lastObstacle = row;
                        }
                        break;

                    case '.':
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RotateBox rotateBox = new RotateBox();
        System.out.println(ArrayUtils.printArray2d(ArrayUtils.wrapper(rotateBox.rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        }))));

        System.out.println(ArrayUtils.printArray2d(ArrayUtils.wrapper(rotateBox.rotateTheBox(new char[][]{
                {'#', '.', '#'}
        }))));

        System.out.println(ArrayUtils.printArray2d(ArrayUtils.wrapper(rotateBox.rotateTheBox(new char[][]{
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        }))));
    }
}


