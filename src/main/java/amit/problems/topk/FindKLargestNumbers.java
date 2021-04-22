package amit.problems.topk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for(int num: nums) {
            if(minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if(minHeap.peek() < num) {
                    minHeap.remove();
                    minHeap.add(num);
                }
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
