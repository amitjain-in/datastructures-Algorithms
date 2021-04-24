package amit.problems.lists;

/**
 * *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 *
 * https://leetcode.com/problems/reverse-linked-list-ii
 *
 * Status works
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ReverseBetween rb = new ReverseBetween();
        System.out.println(rb.reverseBetween(ListNode.toList(new int[]{3,5}), 1, 2));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode curr = head;
        ListNode prev = null;

        int i = 1;

        while(i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode leftNode = prev;
        ListNode rightNode = curr;
        ListNode next = null;

        while (curr != null && i++ <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(leftNode == null) {
            head = prev;
        } else if (leftNode != prev) {
             leftNode.next = prev;
        }
        if(rightNode != null)
            rightNode.next = curr;//This is going to be one after Q

        return head;
    }

}

