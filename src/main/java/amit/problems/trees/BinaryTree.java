package amit.problems.trees;

/**
 * This is a binary tree and not binary search tree.
 *
 * @param <T>
 */
public class BinaryTree<T> {

    private TreeNode<T> root;

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
        return root + (root.getLeft() != null ? traverseInOrder(root.getLeft()) : "...") + (root.getRight() != null ? traverseInOrder(root.getRight()) : "...");
    }

    private String traversePostOrder(TreeNode<T> root) {
        return (root.getLeft() != null ? traverseInOrder(root.getLeft()) : "...") + (root.getRight() != null ? traverseInOrder(root.getRight()) : "...") + root;
    }
}

class TreeNode<T> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return ">" + value;
    }
}
