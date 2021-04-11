package amit.problems.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Given a binary tree imagine what the tree would look like if you were standing on the right side of the tree.
 * Now print that tree from top to bottom.
 * Reference - https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    //First attempt - cleared all test cases
    public List<Integer> rightSideView(TreeNode root) {
        //We are keeping two queues to maintain alternate level elements.
        //when any queue isEmpty while polling we know that level is complete and the last node of the queue is the right most element of that tree
        //We use a flag to denote the moment when we have incremented a level.
        Queue<TreeNode> q1 = new LinkedBlockingDeque<>();
        Queue<TreeNode> q2 = new LinkedBlockingDeque<>();
        List<Integer> output = new LinkedList<>();

        boolean isQ1 = true;//Flag to alternate between levels

        if (root != null) {//There was a test case where root was null. Hence this condition.
            q1.add(root);
            TreeNode lastNodeAtLevel = root;
            while (!q1.isEmpty() || !q2.isEmpty()) {
                Queue<TreeNode> q = isQ1 ? q1 : q2;
                TreeNode node = q.poll();
                if (node != null) {
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                    lastNodeAtLevel = node;
                } else {
                    output.add(lastNodeAtLevel.val);
                    isQ1 = !isQ1;
                }
            }
            output.add(lastNodeAtLevel.val);//Last node to be traversed will always be missed, hence add here.
        }
        return output;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
