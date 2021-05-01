package amit.problems;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum
 */
public class ThreeEqualParts {

    public static void main(String[] args) {
        ThreeEqualParts tep = new ThreeEqualParts();
        System.out.println(tep.canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{18, 12, -18, 18, -19, -1, 10, 10}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{6, 1, 1, 13, -1, 0, -10, 20}));
        System.out.println(tep.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));


    }

    //Status works
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int left = 0, leftSum = 0;
        int right = arr.length - 1, rightSum = 0;


        do {
            leftSum += arr[left];
            left++;
        } while (leftSum != target && left < arr.length);

        do {
            rightSum += arr[right];
            right--;
        } while (rightSum != target && right >= left);

        return leftSum == target && rightSum == target && left <= right;
    }
}
