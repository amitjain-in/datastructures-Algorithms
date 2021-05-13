package amit.problems.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order
 *
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {

    //Status works;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new LinkedList<>();
        combine(1, n, k, new ArrayList<>(k), results);
        return results;
    }

    private void combine(int start, int end, int k, List<Integer> result, List<List<Integer>> allResults) {
        if (k == 0) {
            allResults.add(result);
            return;
        }

        for (int i = start; i <= end - k + 1; i++) {
            List<Integer> newResult = new ArrayList<>(result);
            newResult.add(i);
            combine(i + 1, end, k - 1, newResult, allResults);
        }
    }
}
