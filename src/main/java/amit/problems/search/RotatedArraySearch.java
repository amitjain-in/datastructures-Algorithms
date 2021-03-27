package amit.problems.search;

//This only works for unique elements. For repeated elements, in some cases it fails.
public class RotatedArraySearch {

    public static void main(String[] args) {
        RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();
//        System.out.println(rotatedArraySearch.findElement(new int[]{5, 6, 7, 1, 2, 3, 4}, 5)); //0
//        System.out.println(rotatedArraySearch.findElement(new int[]{5, 6, 7, 1, 2, 3, 4}, 4)); //6
//        System.out.println(rotatedArraySearch.findElement(new int[]{5, 6, 7, 1, 2, 3, 4}, 7)); //2
//        System.out.println(rotatedArraySearch.findElement(new int[]{1, 2, 3, 4, 5, 6, 7}, 7)); //6
//        System.out.println(rotatedArraySearch.findElement(new int[]{1, 2, 3, 4}, 1)); //0
//        System.out.println(rotatedArraySearch.findElement(new int[]{1, 2, 3, 4}, 5)); //-1
        System.out.println(rotatedArraySearch.findElement(new int[]{-4, -4, -3, -3, -3, -3, -3, -3, -3, -2, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 10, 10, 10, 10, -10, -10, -10, -9, -9, -9, -9, -8, -8, -8, -7, -7, -7, -6, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4}
                , 10)); //-1);
    }

    public int findElement(int[] arr, int element) {
        int pivot = findPivot(arr);
        if (arr[arr.length - 1] < element) {
            return binarySearch(arr, element, 0, pivot);
        } else {
            return binarySearch(arr, element, pivot, arr.length - 1);
        }
    }

    public int binarySearch(int[] arr, int element, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == element) {
            return mid;
        } else if (arr[mid] > element) {
            return binarySearch(arr, element, left, mid - 1);
        } else {
            return binarySearch(arr, element, mid + 1, right);
        }
    }


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
