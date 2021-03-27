package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * # Input
 * - The given tree is non-empty.
 * - Each node in the tree has unique values 0 <= node.val <= 500.
 * - The target node is a node in the tree.
 * - 0 <= K <= 1000.
 * <p>
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, target, K, list);
        //preOrder(root, target, K, list);
        postOrder(root, target, K, list);
        return list;
    }

    //If the target node is found, then we pass it as null
    public void inOrder(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, target, k, result);
            if (target != null && target.val != root.val) {
                inOrder(root.right, target, k, result);
            } else {
                if (k == 0) {
                    result.add(root.val);
                } else {
                    inOrder(root.right, null, k - 1, result);
                }
            }
        }
    }

    public void preOrder(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root != null) {
            if (target != null && target.val != root.val) {
                preOrder(root.left, target, k, result);
                preOrder(root.right, target, k, result);
            } else {
                if (k == 0) {
                    result.add(root.val);
                } else {
                    preOrder(root.left, null, k - 1, result);
                    preOrder(root.right, null, k - 1, result);
                }
            }
        }
    }

    public int postOrder(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root != null) {
            int found = postOrder(root.right, target, k, result);
            if (target != null && target.val != root.val) {
                postOrder(root.left, target, k, result);
            } else {
                if (k == 0) {
                    result.add(root.val);
                } else {
                    postOrder(root.left, null, k - 1, result);
                }
            }
        }
        return -1;
    }
}

