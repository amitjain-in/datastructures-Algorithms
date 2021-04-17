package amit.problems.lists;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseEveryKElements {


    public static ListNode reverse(ListNode head, int k) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int i = 1;
        ListNode pNode = null;
        ListNode qNode = head;

        while (curr != null) {
            while (curr != null && i++ <= k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(pNode != null ) {
                pNode.next = prev;//This is going to be Q, hence attach it after our pre P element
            } else {
                head = prev;
            }
            qNode.next = curr;//This is going to be one after Q
            pNode = qNode;
            qNode = curr;
            i = 1;
        }


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
