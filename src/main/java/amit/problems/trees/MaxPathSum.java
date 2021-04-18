package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
 *
 * A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root. The path must contain at least one node.
 */
public class MaxPathSum {

    public static int findMaximumPathSum(TreeNode root) {
        int[] atomicInteger = new int[1];
        atomicInteger[0] = Integer.MIN_VALUE;
        findMaximumPathSum(root, atomicInteger);
        return atomicInteger[0];
    }

    private static int findMaximumPathSum(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }
        int left = findMaximumPathSum(root.left, maxPath);
        int right = findMaximumPathSum(root.right, maxPath);
        int pathSum = root.val + left + right;
        maxPath[0] = Math.max(maxPath[0], pathSum);
        return Math.max(left, right) + root.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));//6 = 2 -> 1 - > 3

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));//31 = 8 -> 5 -> 3 -> 6 -> 9

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));// -3 //This is actually incorrect
    }
}
