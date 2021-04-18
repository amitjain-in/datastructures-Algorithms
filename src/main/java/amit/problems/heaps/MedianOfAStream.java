package amit.problems.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private int size = 0;

    public void insertNum(int num) {
        size++;
        if(minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        while(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(size % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if(minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }


}
