package amit.problems.topk;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        PriorityQueue<Number> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        HashMap<Integer, Number> map = new HashMap<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                Number numb = map.computeIfAbsent(num, n -> new Number(num));
                numb.freq++;
                minHeap.add(numb);
            } else {
                Number numb = map.computeIfAbsent(num, n -> new Number(num));
                numb.freq++;
                if (minHeap.peek().freq < numb.freq) {
                    minHeap.remove();
                    minHeap.add(numb);
                }
            }
        }

        return minHeap.stream().map(number -> number.number).collect(Collectors.toList());
    }

    static class Number {
        final int number;
        int freq = 0;

        public Number(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{5, 12, 11, 3, 11, 5}, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}