package amit.problems.topk;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 *
 * The class should have the following two things:
 *
 *     The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
 *     The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 */
public class KthLargestNumberInStream {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    private final int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {
        if (minHeap.size() < k) {
            minHeap.add(num);
        } else {
            if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6)); //5
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));//6
        System.out.println("4th largest number is: " + kthLargestNumber.add(4)); //6
    }
}