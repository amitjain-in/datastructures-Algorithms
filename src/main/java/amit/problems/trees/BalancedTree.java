package amit.problems.trees;

public class BalancedTree {

    public static void main(String[] args) {
        TreeNode<Character> root = singleNode();
        checkBalance(root);
        TreeNode<Character> root1 = notBalance();
        checkBalance(root1);
    }

    private static void checkBalance(TreeNode<Character> root) {
        BinaryTree<Character> tree = new BinaryTree<>(root);
        System.out.println(tree);
        System.out.println(tree.isBalanced());
    }

    private static TreeNode<Character> singleNode() {
        return new TreeNode<>('A');
    }

    private static TreeNode<Character> notBalance() {
        TreeNode<Character> root = new TreeNode<>('A');
        TreeNode<Character> l1 = new TreeNode<>('B');
        TreeNode<Character> r1 = new TreeNode<>('C');
        root.setLeft(l1);
        root.setRight(r1);
        TreeNode<Character> l2 = new TreeNode<>('D');
        l1.setLeft(l2);
        TreeNode<Character> l3 = new TreeNode<>('E');
        l2.setLeft(l3);
        return root;
    }
}
