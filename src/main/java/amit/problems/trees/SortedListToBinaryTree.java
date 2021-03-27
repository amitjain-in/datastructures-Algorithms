package amit.problems.trees;

import amit.problems.lists.ListNode;
import amit.problems.trees.inttree.TreeNode;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Status: works
 */
public class SortedListToBinaryTree {

    public TreeNode sortedListToBST(ListNode head) {
        int listLen = findListLength(head);
        return createTree(head, 0, listLen - 1);
    }

    int findListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    TreeNode createTree(ListNode head, int start, int end) {
        if (head == null || end < start) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = createTree(head, start, mid - 1);
        int midCtr = start;
        while (midCtr < mid) {
            head = head.next;
            midCtr++;
        }

        TreeNode node = new TreeNode(head.val);
        node.left = left;
        node.right = createTree(head.next, mid + 1, end);
        return node;
    }
}