package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

//Serialiser/Deserialser for binary tree
public class BinaryTreeSerde {

    private static final String DELIM = ",";
    private static final String NULL = "--";

    public void serialise(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL + DELIM);
            return;
        }
        sb.append(root.val + DELIM);
        serialise(root.left, sb);
        serialise(root.right, sb);
    }
//
//    public TreeNode deserialise(String str) {
//
//    }
}
