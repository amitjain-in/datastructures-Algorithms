package amit.problems.search;

public class RotatedArraySearch {

    static int findPivot(int[] arr) {
        int midIdx = 0;
        int high = arr.length - 1;
        int low = 0;


        while (low < high) {
            midIdx = low + (high - low) / 2;

            if (arr[low] < arr[high]) {
                midIdx = low;
                break;
            }

            if (arr[high - 1] > arr[high]) {
                midIdx = high;
                break;
            }

            if ((midIdx > 0 && arr[midIdx - 1] > arr[midIdx])) {
                break;
            }

            if (arr[low] > arr[midIdx]) {
                high = midIdx - 1;
            } else {
                low = midIdx + 1;
            }
        }
        return midIdx;
    }
}
