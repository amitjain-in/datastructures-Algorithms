package amit.problems.trees;

/**
 * This is a binary tree and not binary search tree.
 *
 * @param <T>
 */
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public String inOrder() {
        return traverseInOrder(root);
    }

    public String preOrder() {
        return traversePreOrder(root);
    }

    public String postOrder() {
        return traversePostOrder(root);
    }

    private String traverseInOrder(BinaryTreeNode<T> root) {
        return (root.getLeft() != null ? traverseInOrder(root.getLeft()) : "...") + root + (root.getRight() != null ? traverseInOrder(root.getRight()) : "...");
    }

    private String traversePreOrder(BinaryTreeNode<T> root) {
        return root + (root.getLeft() != null ? traversePreOrder(root.getLeft()) : "...") + (root.getRight() != null ? traversePreOrder(root.getRight()) : "...");
    }

    private String traversePostOrder(BinaryTreeNode<T> root) {
        return (root.getLeft() != null ? traversePostOrder(root.getLeft()) : "...") + (root.getRight() != null ? traversePostOrder(root.getRight()) : "...") + root;
    }

    public int maxDepth(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }

    public int minDepth(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
    }

    public boolean isBalanced() {
        return maxDepth(root) - minDepth(root) < 2;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}


