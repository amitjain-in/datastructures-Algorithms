package amit.problems.search;

/**
 * Given a sorted array which can contain duplicates find the first and last occurrence of a given element in the array.
 * It is assumed that the element exists in the array.
 *
 * Reference: The Algorithm Design Manual by Skiena - Section 4.9.1 Page 133
 */
public class BinarySearchBounded {

    //You can find test cases in BinarySearchBoundedTest
    static int[] sortedBounded(int[] array, int element) {
        return new int[]{
                binarySearchLeft(array, element, 0, array.length - 1),
                binarySearchRight(array, element, 0, array.length - 1)};
    }

    //Modified binary search where we have removed the equality condition and let the search fail till start > end.
    //At this moment we have founded the upper bound or the lower bound of the element to be searched.
    static int binarySearchRight(int[] array, int key, int start, int end) {
        if (start > end) {
            return end;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] > key) {
            return binarySearchRight(array, key, start, midIdx - 1);
        } else {
            return binarySearchRight(array, key, midIdx + 1, end);
        }
    }

    static int binarySearchLeft(int[] array, int key, int start, int end) {
        if (start > end) {
            return start;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] < key) {
            return binarySearchLeft(array, key, midIdx + 1, end);
        } else {
            return binarySearchLeft(array, key, start, midIdx - 1);
        }
    }
}
