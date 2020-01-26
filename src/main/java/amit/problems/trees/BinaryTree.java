package amit.problems.trees;

/**
 * This is a binary tree and not binary search tree.
 *
 * @param <T>
 */
public class BinaryTree<T> {

    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
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

    private String traverseInOrder(TreeNode<T> root) {
        return (root.getLeft() != null ? traverseInOrder(root.getLeft()) : "...") + root + (root.getRight() != null ? traverseInOrder(root.getRight()) : "...");
    }

    private String traversePreOrder(TreeNode<T> root) {
        return root + (root.getLeft() != null ? traversePreOrder(root.getLeft()) : "...") + (root.getRight() != null ? traversePreOrder(root.getRight()) : "...");
    }

    private String traversePostOrder(TreeNode<T> root) {
        return (root.getLeft() != null ? traversePostOrder(root.getLeft()) : "...") + (root.getRight() != null ? traversePostOrder(root.getRight()) : "...") + root;
    }

    public int maxDepth(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }

    public int minDepth(TreeNode<T> root) {
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


