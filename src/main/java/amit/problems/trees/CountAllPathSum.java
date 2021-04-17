package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.HashMap;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
 */
public class CountAllPathSum {

    public static int countPaths(TreeNode root, int S) {
        return countPaths(root, S, new HashMap<>(), 0);
    }

    private static int countPaths(TreeNode root, int s, HashMap<Integer, Integer> sums, int runningSum) {
        if (root == null) {
            return 0;
        }
        runningSum += root.val;
        int sumExists = sums.getOrDefault(runningSum - s, 0);
        sums.put(runningSum, sums.getOrDefault(runningSum, 0) + 1);
        sumExists += countPaths(root.left, s, new HashMap<>(sums), runningSum);
        sumExists += countPaths(root.right, s, new HashMap<>(sums), runningSum);
        return sumExists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
