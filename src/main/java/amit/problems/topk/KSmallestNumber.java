package amit.problems.topk;

import java.util.PriorityQueue;

public class KSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for(int num: nums) {
            if(maxHeap.size() < k) {
                maxHeap.add(num);
            } else {
                if(maxHeap.peek() > num) {
                    maxHeap.remove();
                    maxHeap.add(num);
                }
            }
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        int result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
