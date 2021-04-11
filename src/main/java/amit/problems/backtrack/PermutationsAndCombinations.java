package amit.problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Credit - All code taken from reference page below link.
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class PermutationsAndCombinations {

    public static void main(String[] args) {
        PermutationsAndCombinations pac = new PermutationsAndCombinations();
//        int[] arr = new int[]{7, 4, 5, 8};
//        int[] arrWDup = new int[]{7, 4, 5, 8, 4, 5, 5};
//        /*System.out.println("Subsets: " + pac.subsets(arr));
//        System.out.println("Subsets with Dup: " + pac.subsetsWithDup(arrWDup));*/
//        System.out.println("Permutations: " + pac.permute(arr));
//        System.out.println("Permutations with Dup: " + pac.permuteUnique(arrWDup));
//
//        System.out.println("Palindrome Partitioning: " + pac.partition("aaabbc"));

        pac.printNumbersOfIntervals(new int[][]{{1, 3}, {4, 5}, {5, 6}});
    }

    //https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        //nums shouldn't contain duplicates
        List<List<Integer>> list = new ArrayList<>();
        backtrackSubSet(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrackSubSet(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrackSubSet(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //With duplicates https://leetcode.com/problems/subsets-ii/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubSetWithDup(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrackSubSetWithDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackSubSetWithDup(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    //Permutations including all elements.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackPermute(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrackPermute(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackPermuteDup(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrackPermuteDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrackPermuteDup(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //CombinationSum https://leetcode.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackCombinationSum(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrackCombinationSum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain >= 0) {
            if (remain == 0) list.add(new ArrayList<>(tempList));
            else {
                for (int i = start; i < nums.length; i++) {
                    tempList.add(nums[i]);
                    backtrackCombinationSum(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    //With Duplicate https://leetcode.com/problems/combination-sum-ii/
    public List<List<Integer>> combinationSumWithDup(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackCombinationSumWithDup(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrackCombinationSumWithDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain >= 0) {
            if (remain == 0) list.add(new ArrayList<>(tempList));
            else {
                for (int i = start; i < nums.length; i++) {
                    if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                    tempList.add(nums[i]);
                    backtrackCombinationSumWithDup(list, tempList, nums, remain - nums[i], i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    //https://leetcode.com/problems/palindrome-partitioning/
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrackPalindrome(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrackPalindrome(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length())
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrackPalindrome(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }


    // Permutation of intervals
    // Supposed you are given a set of intervals. Print all possible number combinations of those interval including the integer range between the intervals.
    // E.g. two intervals [1, 3] [4, 5]. Then you need to print 14, 15, 24, 25 24 25. Because 1,3 expands to 1,2,3 and combination of each of those with second interval
    // First element of an interval will always be smaller or equal to second element.
    public void printNumbersOfIntervals(int[][] intervals) {
        printNumbersOfIntervals(intervals, 0, (int) Math.pow(10, intervals.length - 1), 0);
    }

    private void printNumbersOfIntervals(int[][] intervals, int i, int tens, int add) {
        if (i == intervals.length) {
            System.out.println(add);
            return;
        }
        int interval = intervals[i][0];
        int endInterval = intervals[i][1];
        while (interval <= endInterval) {
            printNumbersOfIntervals(intervals, i + 1, tens / 10, interval * tens + add);
            interval++;
        }
    }
}
