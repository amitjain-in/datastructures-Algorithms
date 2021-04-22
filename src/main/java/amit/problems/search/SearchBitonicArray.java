package amit.problems.search;

public class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int maxIdx = findMax(arr);
        int left = 0, right = arr.length - 1;
        int searchLeft = binarySearch(arr, key, left, maxIdx);
        if (searchLeft == -1) {
            searchLeft = binarySearchDescending(arr, key, maxIdx, right);
        }
        return searchLeft;
    }

    static int binarySearch(int[] array, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] == key) {
            return midIdx;
        } else if (array[midIdx] > key) {
            return binarySearch(array, key, start, midIdx - 1);
        } else {
            return binarySearch(array, key, midIdx + 1, end);
        }
    }

    static int binarySearchDescending(int[] array, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        if (array[midIdx] == key) {
            return midIdx;
        } else if (array[midIdx] < key) {
            return binarySearch(array, key, start, midIdx - 1);
        } else {
            return binarySearch(array, key, midIdx + 1, end);
        }
    }

    static int findMax(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[]{1, 3, 8, 4, 3}, 4));//3
        System.out.println(SearchBitonicArray.search(new int[]{3, 8, 3, 1}, 8));//1
        System.out.println(SearchBitonicArray.search(new int[]{1, 3, 8, 12}, 12));//3
        System.out.println(SearchBitonicArray.search(new int[]{10, 9, 8}, 10));//0
    }
}
