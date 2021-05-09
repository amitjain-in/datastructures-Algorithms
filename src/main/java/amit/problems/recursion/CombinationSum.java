package amit.problems.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {


    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));//[[2,2,3],[7]]
        System.out.println(cs.combinationSum(new int[]{2, 3, 5}, 8));//
        System.out.println(cs.combinationSum(new int[]{2}, 1));//
        System.out.println(cs.combinationSum(new int[]{3, 5, 8}, 11));//[[3,3,5],[3,8]]
    }

    /**
     * Status: works but there is a better solution in @see amit.problems.recursion.PermutationsAndCombinations.combinationSum()
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        List<List<Integer>> result = combinationSum(candidates, new LinkedList<>(), target, 0);
        if (result != null) {
            results.addAll(result);
        }
        return results;
    }

    private List<List<Integer>> combinationSum(int[] candidates, List<Integer> list, int target, int start) {
        if (target == 0) {
            List<List<Integer>> tempResults = new LinkedList<>();
            tempResults.add(list);
            return tempResults;
        }

        if (target < 0 || start >= candidates.length) {
            return null;
        }

        List<List<Integer>> results = new LinkedList<>();
        for (int i = start; i < candidates.length; i++) {
            List<Integer> ithList = new LinkedList<>(list);
            int ithTarget = target;
            while (ithTarget > 0) {

                ithList.add(candidates[i]);
                List<Integer> newList = new ArrayList<>(ithList);
                List<List<Integer>> result = combinationSum(candidates, newList, ithTarget - candidates[i], i + 1);
                if (result != null) {
                    results.addAll(result);
                }
                ithTarget -= candidates[i];
            }
        }


        return results;
    }
}