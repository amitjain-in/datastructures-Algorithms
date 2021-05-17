package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 *
 * Given the root of a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class BinaryTreeToGreaterTree {

    public static void main(String[] args) {
        BinaryTreeToGreaterTree tree = new BinaryTreeToGreaterTree();
        System.out.println(tree.convertBST(TreeNode.arrayToTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})));
    }

    //Status works
    public TreeNode convertBST(TreeNode root) {
        if(root != null) {
            traverse(root, 0);
        }
        return root;
    }

    //Since calculating greater sum all the elements will be found on the right children, we need to traverse right->root->left and recursively calculate sum
    //And use the same sum value to add in root.
    private int traverse(TreeNode root, int sum) {
        if(root.right != null) {
            sum = traverse(root.right, sum);
        }
        sum += root.val;
        root.val = sum;
        if(root.left != null) {
            sum = traverse(root.left, sum);
        }

        return sum;
    }
}
