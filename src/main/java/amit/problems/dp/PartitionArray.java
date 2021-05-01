package amit.problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array find if you can divide the array elements into two subsets with equal sum.
 * <p>
 * e.g. [1, 3, 2] = [3] & [1, 2] both are having sum as 3 to output should be true
 * e.g. [3, 2, 2] = false it is not possible to divide this array into two subsets with equal sum.
 */
public class PartitionArray {

    public static void main(String[] args) {
        PartitionArray pa = new PartitionArray();

        System.out.println(pa.canPartitionEqually(new int[]{1, 2, 3}));
        System.out.println(pa.canPartitionEqually(new int[]{1, 3, 2}));
        System.out.println(pa.canPartitionEqually(new int[]{3, 2, 2}));

        System.out.println(pa.canPartitionEquallyAlternate(new int[]{1, 2, 3}));
        System.out.println(pa.canPartitionEquallyAlternate(new int[]{1, 3, 2}));
        System.out.println(pa.canPartitionEquallyAlternate(new int[]{3, 2, 2}));
    }

    public boolean canPartitionEqually(int[] arr) {
        int arraySum = Arrays.stream(arr).sum();

        if (arraySum % 2 != 0) { //You can divide equally if total itself is not even
            return false;
        }

        return canPartitionEqually(arr, 0, arraySum / 2, new HashMap<>());//We will find subset within this array which is one half
    }

    private boolean canPartitionEqually(int[] arr, int index, int sum, HashMap<String, Boolean> memo) {
        if (index == arr.length) {//if the numbers are going to be positive only then you can add sum < 0 check in or condition over here.
            return false;
        }
        if (sum == 0) {
            return true;
        }
        String key = index + "_" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        //Either you exclude this element in the sum or include, reduce the sum.
        boolean match = canPartitionEqually(arr, index + 1, sum, memo) || canPartitionEqually(arr, index + 1, sum - arr[index], memo);
        memo.put(key, match);
        return match;
    }

    public boolean canPartitionEquallyAlternate(int[] arr) {
        HashSet<Integer> prevSums = new HashSet<>();
        HashSet<Integer> currSums = new HashSet<>();

        prevSums.add(0);
        for (int elem : arr) {
            for (int prevSum : prevSums) {
                currSums.add(prevSum - elem);
                currSums.add(prevSum + elem);
            }
            prevSums = new HashSet<>(currSums);
            currSums.clear();
        }
        return prevSums.contains(0);
    }
}
