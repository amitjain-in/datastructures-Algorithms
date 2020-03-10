package amit.problems.heaps;

public class MinHeap {
    private static final int DEFAULT_SIZE = 100;

    private int [] heap;
    private int sz = 0;

    public MinHeap() {
        this(DEFAULT_SIZE);
    }

    public MinHeap(int maxSize) {
        heap = new int[maxSize];
    }

    public void insert(int element) {
        if(sz == heap.length) {
            throw new RuntimeException("Heap overflow error. Max size: " + heap.length);
        }
        heap[sz] = element;
        int start = sz;
        int newStart = sz/2;
        while(heap[newStart] > heap[start] && start > 0) {
            int tmp = heap[newStart];
            heap[newStart] = heap[start];
            heap[start] = tmp;
            start = newStart;
            newStart = start/2;
        }
        sz++;
    }

    public boolean remove(int element) {
        //TODO Implement
        return false;
    }

    public int getMin() {
        if(sz == 0) {
            throw new RuntimeException("No elements in heap");
        }
        return heap[0];
    }

    public int size() {
        return sz;
    }
}
