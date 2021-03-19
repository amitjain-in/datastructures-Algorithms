package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * TODO Status not working
 */
public class BinaryTreeToGreaterTree {

    public static void main(String[] args) {
        BinaryTreeToGreaterTree tree = new BinaryTreeToGreaterTree();
        System.out.println(tree.convertBST(TreeNode.arrayToTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})));
    }

    public TreeNode convertBST(TreeNode root) {
        traversePost(root, 0);
        return root;
    }

    public int traversePost(TreeNode root, int runSum) {
        if (root == null) return runSum;

        if (root.right != null) {
            root.val += traversePost(root.right, runSum);// + (root.right != null ? root.right.val : 0);;
        }

        if (root.left != null) {
            traversePost(root.left, runSum);
            root.left.val += root.val;
            return root.left.val;
        }
        return root.val;
    }


}
