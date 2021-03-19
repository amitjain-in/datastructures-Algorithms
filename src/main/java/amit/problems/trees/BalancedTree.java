package amit.problems.trees;

public class BalancedTree {

    public static void main(String[] args) {
        BinaryTreeNode<Character> root = singleNode();
        checkBalance(root);
        BinaryTreeNode<Character> root1 = notBalance();
        checkBalance(root1);
    }

    private static void checkBalance(BinaryTreeNode<Character> root) {
        BinaryTree<Character> tree = new BinaryTree<>(root);
        System.out.println(tree);
        System.out.println(tree.isBalanced());
    }

    private static BinaryTreeNode<Character> singleNode() {
        return new BinaryTreeNode<>('A');
    }

    private static BinaryTreeNode<Character> notBalance() {
        BinaryTreeNode<Character> root = new BinaryTreeNode<>('A');
        BinaryTreeNode<Character> l1 = new BinaryTreeNode<>('B');
        BinaryTreeNode<Character> r1 = new BinaryTreeNode<>('C');
        root.setLeft(l1);
        root.setRight(r1);
        BinaryTreeNode<Character> l2 = new BinaryTreeNode<>('D');
        l1.setLeft(l2);
        BinaryTreeNode<Character> l3 = new BinaryTreeNode<>('E');
        l2.setLeft(l3);
        return root;
    }
}
