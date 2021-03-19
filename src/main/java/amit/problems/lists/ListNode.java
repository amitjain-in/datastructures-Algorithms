package amit.problems.lists;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + (next != null ? ", " + next.toString() : "]");
    }

    public static ListNode toList(int[] arr) {
        ListNode head = new ListNode(arr[0]);

        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            node.next = newNode;
            node = newNode;
        }
        return head;
    }
}