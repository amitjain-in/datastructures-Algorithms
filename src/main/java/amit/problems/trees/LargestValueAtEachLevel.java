package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Status working: both the solutions.
 */
public class LargestValueAtEachLevel {

    public List<Integer> largestValuesUsingMap(TreeNode root) {
        Map<Integer, Integer> maxValues = new HashMap<>();
        maxRowsUsingMap(root, maxValues, 0);
        return maxValues.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
    }


    public void maxRowsUsingMap(TreeNode root, Map<Integer, Integer> maxValues, int level) {
        if (root != null) {
            Integer maxValue = maxValues.get(level);
            if (maxValue == null || root.val > maxValue) {
                maxValues.put(level, root.val);
            }
            maxRowsUsingMap(root.left, maxValues, level + 1);
            maxRowsUsingMap(root.right, maxValues, level + 1);
        }
    }

    //This is faster as there is not sorting in the end.
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new ArrayList<>();
        maxRows(root, maxValues, 0);
        return maxValues;
    }

    public void maxRows(TreeNode root, List<Integer> maxValues, int level) {
        if (root != null) {
            if(maxValues.size() == level){
                maxValues.add(root.val);
            } else {
                Integer maxValue = maxValues.get(level);
                if (root.val > maxValue) {
                    maxValues.set(level, root.val);
                }
            }

            maxRows(root.left, maxValues, level + 1);
            maxRows(root.right, maxValues, level + 1);
        }
    }
}
