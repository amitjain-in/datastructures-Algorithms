package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagTraversal {

    public static void main(String[] args) {

    }

    //Works - but can be optimised for lines of code?
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> leftToRight = new Stack<>();
        Stack<TreeNode> rightToLeft = new Stack<>();
        boolean lToR = true;
        List<List<Integer>> results = new LinkedList<>();

        if(root != null) {
            leftToRight.add(root);
        }
        List<Integer> level = new LinkedList<>();

        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            if (lToR) {
                while (!leftToRight.isEmpty()) {
                    TreeNode node = leftToRight.pop();
                    level.add(node.val);
                    if (node.left != null) rightToLeft.push(node.left);
                    if (node.right != null) rightToLeft.push(node.right);
                }
                results.add(level);
                level = new LinkedList<>();
                lToR = false;
            } else {
                while(!rightToLeft.isEmpty()) {
                    TreeNode node = rightToLeft.pop();
                    level.add(node.val);
                    if (node.right != null) leftToRight.add(node.right);
                    if (node.left != null) leftToRight.add(node.left);
                }
                results.add(level);
                level = new LinkedList<>();
                lToR = true;
            }
        }

        return results;
    }
}
