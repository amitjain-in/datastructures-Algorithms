package amit.problems.search;

/**
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
 * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
 * <p>
 * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1
 */
public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
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
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, 6)); //1
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12)); //3
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, 17)); //-1
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, -1)); //0 because 4 is the smallest number greater than or equal to 4
    }

}
