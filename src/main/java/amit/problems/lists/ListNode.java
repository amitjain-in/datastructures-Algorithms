package amit.problems.lists;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";// + (next != null ? ", " + next.toString() : "]");
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

    public static String toString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
            if(head != null) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.append("]").toString();
    }
}