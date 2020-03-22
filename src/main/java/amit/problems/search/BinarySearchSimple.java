package amit.problems.search;

public class BinarySearchSimple {

    static int binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length - 1);
    }

    static int binarySearch(int[] array, int key, int start, int end) {
        if(start > end) {
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        if(array[midIdx] == key) {
            return midIdx;
        } else if (array[midIdx] > key) {
            return binarySearch(array, key, start, midIdx - 1);
        } else {
            return binarySearch(array, key, midIdx + 1, end);
        }
    }
}
