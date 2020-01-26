package amit.problems.trees;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
    }

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
        return ">" + value + " L=" + left + " : R=" + right;
    }
}