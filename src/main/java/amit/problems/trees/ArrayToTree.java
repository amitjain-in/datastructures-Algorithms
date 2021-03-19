package amit.problems.trees;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */
public class ArrayToTree {

    public static void main(String[] args) {
        int numberOfElements = 10;
    }

    private static void createTree(int numberOfElements) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(numberOfElements / 2);
        createTree(numberOfElements);
    }
}
