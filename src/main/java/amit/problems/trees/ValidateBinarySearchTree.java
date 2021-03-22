package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Status: working
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, root.val, null) && isValidBST(root.right, null, root.val);
    }

    public boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if(root == null) {
            return true;
        }

        boolean isValid = (max == null || root.val < max) && (min == null || root.val > min);

        return isValid && isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}
