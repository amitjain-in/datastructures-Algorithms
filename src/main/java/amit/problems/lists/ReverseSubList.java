package amit.problems.lists;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’
 */
public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int i = 1;

        while(i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode pNode = prev;
        ListNode qNode = curr;

        while (curr != null && i++ <= q) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        pNode.next = prev;//This is going to be Q, hence attach it after our pre P element
        qNode.next = curr;//This is going to be one after Q
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
