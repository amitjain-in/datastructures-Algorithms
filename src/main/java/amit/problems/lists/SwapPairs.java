package amit.problems.lists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

    //Status works
    public ListNode swapPairs(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode newHead = null;

        while (curr != null && curr.next != null) {
            ListNode currNext = curr.next;//2
            curr.next = currNext.next;//1 -> 3
            currNext.next = curr;//2 -> 1
            if (newHead == null) {
                newHead = currNext;
            }
            if (prev != null) {
                prev.next = currNext;//For next rounds;
            }
            prev = curr;
            curr = curr.next;
        }

        return newHead == null ? head : newHead;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        System.out.println(ListNode.toString(swapPairs.swapPairs(ListNode.toList(new int[]{1, 2, 3, 4}))));
        System.out.println(ListNode.toString(swapPairs.swapPairs(ListNode.toList(new int[]{}))));
        System.out.println(ListNode.toString(swapPairs.swapPairs(ListNode.toList(new int[]{1}))));
    }
}
