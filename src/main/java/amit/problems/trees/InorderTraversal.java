package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.inorderWithoutRecursion(TreeSamples.bstComplete());
        inorderTraversal.inorder(TreeSamples.bstComplete());
    }

    public void inorderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();//This stack would emulate the call stack in otherwise recursive solution.

        while (true) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                return;
            }

            root = stack.pop();

            System.out.println(root.val);//node visited
            root = root.right;
        }
    }

    public void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }
}
