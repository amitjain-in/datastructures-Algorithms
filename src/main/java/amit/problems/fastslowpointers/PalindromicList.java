package amit.problems.fastslowpointers;

import amit.problems.lists.ListNode;

import java.util.Stack;

public class PalindromicList {


    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf;

        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        return head == null || headSecondHalf == null;
    }


    public static boolean isPalindromeWithStack(ListNode head) {
        ListNode mid = findMiddle(head);
        Stack<ListNode> stack = new Stack<>();
        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }
        int median = stack.size();

        while (!stack.isEmpty() && stack.peek() != head) {
            head = head.next;
            stack.pop();
        }

        return median % 2 == 0 ? stack.size() == 0 : stack.size() == 1;
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

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindromeWithStack(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindromeWithStack(head));
    }

}
