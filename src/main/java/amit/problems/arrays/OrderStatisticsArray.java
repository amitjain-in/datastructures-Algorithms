package amit.problems.arrays;

/**
 * Or also called find Kth largest element in an unsorted array using Quick Select algorithm.
 */
public class OrderStatisticsArray {

    public static void main(String[] args) {
        OrderStatisticsArray orderStatisticsArray = new OrderStatisticsArray();
        System.out.println(orderStatisticsArray.findKthLargestElement(new int[]{4, 7, 2, -1, 0}, 3));//2
        System.out.println(orderStatisticsArray.findKthLargestElement(new int[]{5, 4, 7, 2, -1, 0}, 1));//7
        System.out.println(orderStatisticsArray.findKthLargestElement(new int[]{4, 7, 2, -1, 0}, 5));//-1
        System.out.println(orderStatisticsArray.findKthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
        System.out.println(orderStatisticsArray.findKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
    }

    //Status Works
    public  int findKthLargestElement(int[] arr, int k) {
        return findKthLargestElement(arr, 0, arr.length - 1, k);
    }
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], pivotIdx = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swap(arr, pivotIdx, i);
                pivotIdx++;
            }
        }
        swap(arr, high, pivotIdx);
        return pivotIdx;
    }


    private int findKthLargestElement(int[] arr, int low, int high, int k) {

        int partition = partition(arr, low, high);

        if (partition == arr.length - k) {
            return arr[partition];

        } else if (partition < arr.length - k) {
            return findKthLargestElement(arr, partition + 1, high, k);

        } else {
            return findKthLargestElement(arr, low, partition - 1, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
