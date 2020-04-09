package amit.problems.arrays;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class KthSmallestElementInMatrix {

    public static void main(String[] args) {
        KthSmallestElementInMatrix k = new KthSmallestElementInMatrix();
        System.out.println(k.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));//13
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);//max heap
        int rows = matrix.length;

        for (int[] row : matrix) {
            for (int col = 0; col < rows; col++) {
                if (queue.size() < k) {
                    queue.add(row[col]);//Max heap isn't full yet, so just add the elements
                } else {
                    //max heap is full so now we might need to compare and see if we need to remove.
                    if (queue.peek() != null && queue.peek() > row[col]) {
                        //if this element is less than the max element of heap then remove max and store this one in heap
                        queue.poll();
                        queue.add(row[col]);
                    }
                }
            }
        }
        return queue.peek() != null ? queue.poll() : 0;
    }
}
