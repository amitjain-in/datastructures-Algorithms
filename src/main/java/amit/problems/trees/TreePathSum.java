package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Check if there exists a path from root to any leaf whose sum is S.
 */
public class TreePathSum {

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }


    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPaths(root, sum, new LinkedList<>(), allPaths);
        return allPaths;
    }

    private static void findPaths(TreeNode root, int sum, List<Integer> path, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null) {//This is a leaf
            if (sum - root.val == 0) {
                allPaths.add(path);
            }
            return;
        }
        findPaths(root.left, sum - root.val, new LinkedList<>(path), allPaths);
        findPaths(root.right, sum - root.val, new LinkedList<>(path), allPaths);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));

        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}