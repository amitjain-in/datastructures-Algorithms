package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X. *
 * Return the number of good nodes in the binary tree.
 *
 */
public class GoodNodes {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int maxRoot) {
        if(root == null) {
            return 0;
        }
        return (maxRoot >= root.val) ? 1 + goodNodes(root.left, maxRoot) + goodNodes(root.right, maxRoot) : goodNodes(root.left,  root.val) + goodNodes(root.right, root.val);
    }
}
