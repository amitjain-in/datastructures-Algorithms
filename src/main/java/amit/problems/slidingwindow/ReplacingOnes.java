package amit.problems.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s
 */
public class ReplacingOnes {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));//6
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));//9
    }

    //Status works
    public static int findLength(int[] arr, int k) {
        int maxLen = 0;
        int zeroes = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                zeroes++;
            }
            while (zeroes > k) {
                if (arr[start] == 0) {
                    zeroes--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
