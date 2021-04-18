package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 */
public class TreeDiameter {


    public static int findDiameter(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        height(root, diameter);
        return diameter.get();
    }

    public static int height(TreeNode root, AtomicInteger diameter) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);
        int height = 1 + left + right;
        diameter.set(Math.max(diameter.get(), height));
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
//        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));//5
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));//7
    }
}


