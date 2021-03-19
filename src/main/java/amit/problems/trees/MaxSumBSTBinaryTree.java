package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * TODO Not working in some cases
 */
public class MaxSumBSTBinaryTree {

    public static void main(String[] args) {
        MaxSumBSTBinaryTree maxSumBSTBinaryTree = new MaxSumBSTBinaryTree();
//        System.out.println(maxSumBSTBinaryTree.maxSumBST(TreeNode.arrayToTree(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6}))); //20
//        System.out.println(maxSumBSTBinaryTree.maxSumBST(TreeNode.arrayToTree(new Integer[]{4, 3, null, 1, 2, null, null}))); //2
        System.out.println(maxSumBSTBinaryTree.maxSumBST(TreeNode.arrayToTree(new Integer[]{4, 8, null, 6, 1, 9, null, -5, 4, null, null, null, -3, null, 10}))); //14

    }

    public int maxSumBST(TreeNode root) {
        return Math.max(maxBST(root).maxSum, 0);
    }

    public BST maxBST(TreeNode root) {
        BST thisBST = new BST();
        if (root == null) {
            return thisBST;
        }

        if (root.left == null && root.right == null) {
            thisBST.maxSum = root.val;
            return thisBST;
        }

        BST leftBST = maxBST(root.left);
        BST rightBST = maxBST(root.right);
        if (root.left != null && leftBST.isBalanced) {
            if (root.val < root.left.val) {
                thisBST.isBalanced = false;
                thisBST.maxSum = Math.max(leftBST.maxSum, rightBST.maxSum);
                return thisBST;
            }
            thisBST.maxSum = Math.max(Math.max(leftBST.maxSum, rightBST.maxSum), leftBST.maxSum + rightBST.maxSum + root.val);
        }
        if (root.right != null && rightBST.isBalanced) {
            if (root.val > root.right.val) {
                thisBST.isBalanced = false;
                thisBST.maxSum = Math.max(leftBST.maxSum, rightBST.maxSum);
                return thisBST;
            }
            thisBST.maxSum = Math.max(Math.max(leftBST.maxSum, rightBST.maxSum), leftBST.maxSum + rightBST.maxSum + root.val);
        }

        if (!leftBST.isBalanced || !rightBST.isBalanced) {
            thisBST.maxSum = Math.max(leftBST.maxSum, rightBST.maxSum);
        }

        return thisBST;
    }

    static class BST {
        boolean isBalanced = true;
        int maxSum = 0;
    }
}
