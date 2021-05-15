package amit.problems.lists;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions
 *
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    //Status works
    public ListNode partition(ListNode head, int x) {

        if (head != null) {
            ListNode lesserHead = null;
            ListNode greaterHead = null;
            ListNode lesser = null;
            ListNode greater = null;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val < x) {
                    if (lesserHead == null) {
                        lesserHead = curr;
                    } else {
                        lesser.next = curr;
                    }
                    lesser = curr;
                } else {
                    if (greaterHead == null) {
                        greaterHead = curr;
                    } else {
                        greater.next = curr;
                    }
                    greater = curr;
                }

                curr = curr.next;
            }

            if (lesser != null) {
                lesser.next = greaterHead; //Merge the end of lesser and start of greater list.
                head = lesserHead;//Let the head now point to the head of the lesser head list.
                if (greater != null) {
                    greater.next = null; //Make sure the tail is pointing to null.
                }
            } else {
                head = greaterHead;//There were not elements less than 'x' in the list
            }
        }

        return head;
    }

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        System.out.println(ListNode.toString(partitionList.partition(ListNode.toList(new int[]{1, 4, 3, 2, 5, 2}), 3)));
    }
}
