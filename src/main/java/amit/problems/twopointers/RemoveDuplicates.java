package amit.problems.twopointers;

//Give a sorted array, return the length of an array which has all the duplicate elements removed.
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9})); //4
        System.out.println(remove(new int[]{2, 2, 2, 11})); //2
    }

    public static int remove(int[] arr) {

        int prev = 0;
        int next = 1;
        int count = 1;
        while (next < arr.length) {
            if (arr[prev] == arr[next]) {
                next++;
            } else {
                prev = next;
                next++;
                count++;
            }
        }

        return count;
    }
}
