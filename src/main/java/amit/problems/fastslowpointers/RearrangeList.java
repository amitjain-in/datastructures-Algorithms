package amit.problems.fastslowpointers;

import amit.problems.lists.ListNode;

/**
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately
 * to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 */
public class RearrangeList {

    public static void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode endHalf = reverse(slow);
        ListNode headNext = null;
        while (head != null && endHalf != null) {
            headNext = head.next;
            head.next = endHalf;
            head = headNext;
            endHalf.next = headNext;
            endHalf = endHalf.next;
        }

        if(headNext != null) {
            headNext.next = null;//This is the new tail
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    //Status works - Submitted at leetcode https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }//slow now should be the medium

        ListNode left = head;
        ListNode right = reverse(slow);
        while(left != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = null;

            left.next = right;
            if(right != null) {
                rightNext = right.next;
                right.next = leftNext;
            }

            left = leftNext;
            right = rightNext;
        }
    }

}
