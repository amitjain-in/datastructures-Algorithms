package amit.problems;

/**
 * Imagine two friends who start at a common point in an array and then get into a fight. 
 * Now both of these friends would to like to ao away from each other as much as possible in opposite direction.
 * But they can only move if the next/previous block is higher or equal to than where they are currently now.
 *
 * You have to imagine that two friends would be starting optimally somewhere in the array.
 * Find the max possible distance that they will go away from each other
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(block(new int[]{2, 6, 8, 5}));//3
        System.out.println(block(new int[]{1, 5, 5, 2, 6}));//4
        System.out.println(block(new int[]{1, 1}));//2
        System.out.println(block(new int[]{2, 6, 8, 5, 3, 2, 1}));//5
    }

    public static int block(int[] blocks) {
        int max = 0;

        //The idea behind this solution we need to find the biggest (in terms of width) valley within the array. Hence we keep track of
        //index when the block's height start to decrease we would be able to get the length of max valley length.
        int decreaseStart = 0;
        boolean decrease = false;

        for (int i = 1; i < blocks.length; i++) {

            if (blocks[i] < blocks[i - 1] && !decrease) {
                decrease = true;
                decreaseStart = i - 1;
                int j = i - 2;
                while(j >= 0 && blocks[i - 1] == blocks[j]) {
                    j--;
                    decreaseStart = j + 1;
                }
            } else if (blocks[i] > blocks[i - 1]) {
                decrease = false;
            }
            max = Math.max(max, i - decreaseStart + 1);
        }

        return max;
    }
}

