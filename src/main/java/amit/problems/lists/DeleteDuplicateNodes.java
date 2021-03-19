package amit.problems.lists;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * Status not working
 */
public class DeleteDuplicateNodes {

    public static void main(String[] args) {
        DeleteDuplicateNodes deleteDuplicateNodes = new DeleteDuplicateNodes();
//        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 2, 3, 3, 4, 4, 5}));
//        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 1, 1, 2, 3}));
//        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 1, 1, 2, 2, 3}));
//        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 2, 3, 3, 3}));
//        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 1}));
        deleteDuplicateNodes.deleteDuplicates(ListNode.toList(new int[]{1, 1, 2}));
    }

    public ListNode deleteDuplicates(ListNode head) {
        //This does not work
        System.out.println("Input: [" + head);

        ListNode prev = head;
        ListNode node = head != null ? head.next : null;
        ListNode newHead = head != null && node != null && head.val == node.val ? null : head;

        while (node != null) {
            while(node.next != null && node.val == node.next.val) {
                node = node.next;
                prev.next = node.next;
            }
            if(prev.next != null && (node.next == null || prev.next.val != node.next.val)) {
                if(newHead == null) {
                    newHead = node;
                }
                prev.next = node;
                prev = node;
            }
            node = node.next;
        }

        System.out.println("Output: [" + newHead);
        return newHead;
    }

    //This works but we can do it without additional space with using fast and slow pointers.
    public ListNode deleteDuplicatesWithLinkedHashMap(ListNode head) {

        System.out.println("Input: [" + head);
        java.util.LinkedHashMap<Integer, Integer> unique = new LinkedHashMap<>();
        while (head != null) {
            Integer count = unique.getOrDefault(head.val, 0);
            unique.put(head.val, ++count);
            head = head.next;
        }

        ListNode prev = null;
        head = null;
        for (Map.Entry<Integer, Integer> kv : unique.entrySet()) {
            if (kv.getValue() == 1) {
                if(head == null) {
                    head = new ListNode(kv.getKey());
                    prev = head;
                } else {
                    ListNode prevPrev = prev;
                    prev = new ListNode(kv.getKey());
                    prevPrev.next = prev;
                }
            }
        }

        System.out.println("Output: [" + head);
        return head;
    }
}
