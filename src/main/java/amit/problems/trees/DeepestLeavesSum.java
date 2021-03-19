package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * https://leetcode.com/problems/deepest-leaves-sum
 * Status: working
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int height = findHeight(root);
        return findSum(root, height);
    }

    int findSum(TreeNode root, int height) {
        if(root == null) {
            return 0;
        }
        if(height == 1) {
            return root.val;
        } else {
            return findSum(root.left, height - 1) + findSum(root.right, height - 1);
        }
    }

    int findHeight(TreeNode root) {
        if(root == null)  return 0;
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
