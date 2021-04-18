package amit.problems.search;

/**
 * Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’.
 * The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’
 *
 * Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.
 */
public class FloorOfANumber {


    public static int searchFloorOfANumber(int[] arr, int key) {
        if (key < arr[0]) // if the 'key' is smaller than the smallest element
            return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next smaller number will be arr[end]
        return end;
    }

    public static void main(String[] args) {
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[]{4, 6, 10}, 6)); //1
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[]{1, 3, 8, 10, 15}, 12)); //3
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[]{4, 6, 10}, 17)); //2
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[]{4, 6, 10}, -1)); //-1
    }

}
