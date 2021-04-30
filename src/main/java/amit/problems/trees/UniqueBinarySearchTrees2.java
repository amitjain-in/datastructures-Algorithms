package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 uniqueBinarySearchTrees2 = new UniqueBinarySearchTrees2();
        for (int i = 1; i < 9; i++) {
            System.out.println(uniqueBinarySearchTrees2.generateTrees(i));
        }
    }

    //Status works
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return Collections.singletonList(new TreeNode(end));
        }

        List<TreeNode> list = new LinkedList<>();

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            if (lefts != null && rights != null) {
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            } else if (rights == null && lefts != null) {
                for (TreeNode left : lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    list.add(root);
                }
            } else if (rights != null) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    list.add(root);
                }
            }

        }
        return list;
    }

}
