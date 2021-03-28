package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 *
 * Runtime: 1 ms, faster than 50.51% of Java online submissions for Range Sum of BST.
 * Memory Usage: 47.3 MB, less than 36.03% of Java online submissions for Range Sum of BST.
 *
 * https://leetcode.com/problems/range-sum-of-bst
 *
 * Status works
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        } else {
            return (root.val >= low && root.val <= high ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}
