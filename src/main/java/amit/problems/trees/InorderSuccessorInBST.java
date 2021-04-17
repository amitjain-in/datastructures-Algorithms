package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

/**
 * Consider a binary search tree and a key node. You need to provide the inorder successor for that key node.
 */
public class InorderSuccessorInBST {


    public static void main(String[] args) {
        InorderSuccessorInBST inorderSuccessorInBST = new InorderSuccessorInBST();
        System.out.println(inorderSuccessorInBST.inorderSuccessor(TreeSamples.bstComplete(), new TreeNode(5)));
        System.out.println(inorderSuccessorInBST.inorderSuccessor(TreeSamples.bstComplete(), new TreeNode(10)));
        System.out.println(inorderSuccessorInBST.inorderSuccessor(TreeSamples.bstComplete(), new TreeNode(7)));
        System.out.println(inorderSuccessorInBST.inorderSuccessor(TreeSamples.bstComplete(), new TreeNode(13)));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode key) {

        TreeNode successor = null;
        successor = root.val > key.val ? root : root.right;

        while (root != null) {

            if (root.val == key.val) {
                //if it has a right child then left most child of the right child is your successor.
                if (root.right != null) {
                    root = root.right;
                    while (root != null) {
                        successor = root;
                        root = root.left;
                    }
                }
                return successor;

            } else if(root.val < key.val) {
                root = root.right;

            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
