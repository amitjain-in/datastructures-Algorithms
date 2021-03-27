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

    //Works - but can be optimised
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean lToR = true;
        List<List<Integer>> results = new LinkedList<>();

        if(root != null) {
            stack1.add(root);
        }
        List<Integer> level = new LinkedList<>();

        while(!stack1.isEmpty() || !stack.isEmpty()) {
            if (lToR) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    level.add(node.val);
                    if (node.left != null) stack.push(node.left);
                    if (node.right != null) stack.push(node.right);
                }
                results.add(level);
                level = new LinkedList<>();
                lToR = false;
            } else {
                while(!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    level.add(node.val);
                    if (node.right != null) stack1.add(node.right);
                    if (node.left != null) stack1.add(node.left);
                }
                results.add(level);
                level = new LinkedList<>();
                lToR = true;
            }
        }

        return results;
    }
}
