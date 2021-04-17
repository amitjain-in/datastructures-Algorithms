package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree imagine what the tree would look like if you were standing on the right side of the tree.
 * Now print that tree from top to bottom.
 * Reference - https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    //First attempt - cleared all test cases
    public static List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> output = new LinkedList<>();

        if (root != null) {//There was a test case where root was null. Hence this condition.
            q.add(root);
            TreeNode lastNodeAtLevel = root;
            int children = 1;
            while (!q.isEmpty()) {
                while (children-- > 0) {
                    TreeNode node = q.remove();
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                    lastNodeAtLevel = node;
                }
                children = q.size();;
                output.add(lastNodeAtLevel.val);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<Integer> result = rightSideView(root);
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
