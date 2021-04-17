package amit.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int children = 1;

        TreeNode prev = null;

        while (!q.isEmpty()) {
            while (children-- > 0) {
                TreeNode node = q.remove();
                if (prev != null) prev.next = node;

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                prev = node;
            }
            children = q.size();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
}