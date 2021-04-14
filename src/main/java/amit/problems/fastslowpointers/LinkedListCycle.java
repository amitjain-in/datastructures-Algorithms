package amit.problems.fastslowpointers;

import amit.problems.lists.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head)); //false

        head.next.next.next.next.next.next = head.next.next; //3
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head) + " Length: " + findCycleLength(head) + " Cycle Start: " + findCycleStart(head)); //true because we made it cyclic

        head.next.next.next.next.next.next = head.next.next.next; //4
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head) + " Length: " + findCycleLength(head) + " Cycle Start: " + findCycleStart(head)); //true because we made it cyclic

    }

    public static boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) // found the cycle
                return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }


    public static int findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = calculateLength(slow);
                break;
            }
        }
        ListNode ptr1 = head, ptr2 = head;
        while(cycleLength > 0) {
            cycleLength--;
            ptr1 = ptr1.next;
        }
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2.val;
    }
}