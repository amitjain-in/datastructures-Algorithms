package amit.problems.lists;

/**
 * https://leetcode.com/problems/rotate-list
 * Given the head of a linked list, rotate the list to the right by k places.
 * Status: Pass
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) {
            return head;
        }
        int size = 0;
        ListNode tail = null;
        ListNode temp = head;
        while(temp != null) {
            size++;
            tail = temp;
            temp = temp.next;
        }

        tail.next = head;

        int rotation = k % size;
        ListNode newTail = head;
        int rotateBy = size - rotation;
        while(--rotateBy > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

}
