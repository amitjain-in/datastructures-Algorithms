package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Reference https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/
 * I was too lazy, so just copied the code from RightSideView here and done the change.
 */
public class MaxSumAtLevel {
    /**
     * @param root - The tree root
     * @return - The minimum level at which the sum of all values at that level of binary tree is maximum of all levels.
     */
    public int maxLevelSum(TreeNode root) {
        int maxSum = 0;
        int currSum = 0;
        int maxLevel = 0;
        int currLevel = 1;
        Queue<TreeNode> q1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> q2 = new LinkedBlockingQueue<>();

        boolean isQ1 = true;

        if (root != null) {
            q1.add(root);
            maxSum = root.val;
            maxLevel = currLevel;
            currLevel++;
            while (!q1.isEmpty() || !q2.isEmpty()) {
                if (isQ1) {
                    TreeNode node = q1.poll();
                    if (node != null) {
                        currSum += addNodeAndGetVal(node.left, q2);
                        currSum += addNodeAndGetVal(node.right, q2);
                    } else {
                        if (currSum > maxSum) {
                            maxSum = currSum;
                            maxLevel = currLevel;
                        }
                        currSum = 0;
                        currLevel++;
                        isQ1 = false;
                    }
                } else {
                    TreeNode node = q2.poll();
                    if (node != null) {
                        currSum += addNodeAndGetVal(node.left, q1);
                        currSum += addNodeAndGetVal(node.right, q1);
                    } else {
                        if (currSum > maxSum) {
                            maxSum = currSum;
                            maxLevel = currLevel;
                        }
                        currSum = 0;
                        currLevel++;
                        isQ1 = true;
                    }
                }
            }
        }
        return maxLevel;
    }

    private static int addNodeAndGetVal(TreeNode node, Queue<TreeNode> q) {
        if (node != null) {
            q.add(node);
            return node.val;
        }
        return 0;
    }
}
