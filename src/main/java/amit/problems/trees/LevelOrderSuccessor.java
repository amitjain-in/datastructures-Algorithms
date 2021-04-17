package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int children = 1;
        boolean foundNode = false;
        while (!q.isEmpty()) {
            while (children-- > 0) {
                TreeNode node = q.remove();
                if(foundNode) {
                    return node;
                }
                if(node.val == key) {
                    foundNode = true;
                }
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            children = q.size();
        }
        return null;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
