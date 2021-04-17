package amit.problems.lists;

import org.testng.internal.collections.Pair;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        Pair<ListNode, ListNode> newHead = reverse(head, null);
        head.next = null;
        return newHead.second();
    }

    private static Pair<ListNode, ListNode> reverse(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return new Pair<>(prev, head);
        } else {
            Pair<ListNode, ListNode> newHead = reverse(head.next, head);
            newHead.first().next = head;
            return new Pair<>(head, newHead.second());
        }
    }

    private static ListNode reverseNonRecursive(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverseNonRecursive(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
