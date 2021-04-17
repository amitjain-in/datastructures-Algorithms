package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

public class TreeSamples {


    /**
     * 
     * 
     *              10
     *             /  \
     *           5    15
     *         / \    / \
     *       4    7 13   17
     * 
     * 
     * 
     * @return Above tree;
     */
    public static TreeNode bstComplete() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        return root;
    }
}
