package amit.problems.trees.inttree;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    @Override
//    public String toString() {
//        return "\nV = " + val + "[left = " + (left != null ? left.val : null) + ", right = " + (right != null ? right.val : null) + "]";
//    }

    @Override
    public String toString() {
        return "" + val;
    }

    public static TreeNode arrayToTree(Integer[] arr) {

        TreeNode root = new TreeNode();
        root.val = arr[0];
        assignNode(root, arr, 0);
        return root;
    }

    public static void assignNode(TreeNode root, Integer[] arr, int rootIdx) {
        if (rootIdx * 2 + 1 < arr.length) {
            if (arr[rootIdx * 2 + 1] != null) {
                TreeNode left = new TreeNode(arr[rootIdx * 2 + 1]);
                assignNode(left, arr, rootIdx * 2 + 1);
                root.left = left;
            }

            if (rootIdx * 2 + 2 < arr.length) {
                if (arr[rootIdx * 2 + 2] != null) {
                    TreeNode right = new TreeNode(arr[rootIdx * 2 + 2]);
                    assignNode(right, arr, rootIdx * 2 + 2);
                    root.right = right;
                }
            }
        }
    }
}
