package amit.problems.topk;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 */
public class ConnectRopes {

    //Greedy approach. Take the top two min ropes available and join them. This way we always arrive at the lowest cost.
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // add all ropes to the min heap
        for (int ropeLength : ropeLengths) minHeap.add(ropeLength);

        int result = 0, newRope = 0;
        while (minHeap.size() > 1) { // keep doing this until the heap is left with only one rope
            newRope = minHeap.poll() + minHeap.poll(); //take top (lowest) rope lengths from the min heap
            result += newRope;
            minHeap.add(newRope);
        }

        return result;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{3, 4, 5, 6});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5, 2});
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}