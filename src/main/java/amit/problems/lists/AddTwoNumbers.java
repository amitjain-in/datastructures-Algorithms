package amit.problems.lists;

/**
 * https://leetcode.com/problems/add-two-numbers/submissions/
 * Status: Pass
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode temp = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int newVal = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (newVal > 9) {
                carry = 1;
                newVal = newVal - 10;
            } else {
                carry = 0;
            }
            temp.val = newVal;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 != null || l2 != null || carry == 1) {
                ListNode newNode = new ListNode(carry);
                temp.next = newNode;
                temp = newNode;
            }
        }

        return head;
    }

}
