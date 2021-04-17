package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 */
public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumbersInner(root, 0);
    }

    public static int findSumOfPathNumbersInner(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return findSumOfPathNumbersInner(root.left, sum) + findSumOfPathNumbersInner(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
