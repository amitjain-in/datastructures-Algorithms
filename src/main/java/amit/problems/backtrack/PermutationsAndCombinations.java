package amit.problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Credit - All code taken from reference page here. https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class PermutationsAndCombinations {

    //https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
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


    //Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
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
        Arrays.sort(nums);
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

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
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
}
