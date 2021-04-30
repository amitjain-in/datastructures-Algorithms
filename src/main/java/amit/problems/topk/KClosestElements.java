package amit.problems.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
 * Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 */
public class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Entry> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int num : arr) {
            int diff = Math.abs(X - num);
            if (maxHeap.size() < K) {
                maxHeap.add(new Entry(num, diff));
            } else {
                if (maxHeap.peek().value > diff) {
                    maxHeap.poll();
                    maxHeap.add(new Entry(num, diff));
                }
            }
        }
        for (Entry entry : maxHeap) {
            result.add(entry.key);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[]{2, 4, 5, 6, 9}, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
