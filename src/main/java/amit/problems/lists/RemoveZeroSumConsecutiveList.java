package amit.problems.lists;

import java.util.HashMap;

/**
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 *
 * After doing so, return the head of the final linked list.  You may return any such answer.
 *
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 *
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 *
 * Status works
 */
public class RemoveZeroSumConsecutiveList {


    public static void main(String[] args) {
        RemoveZeroSumConsecutiveList r = new RemoveZeroSumConsecutiveList();
        System.out.println(ListNode.toString(r.removeZeroSumSublists(ListNode.toList(new int[]{1, 2, -3, 3, 1})))); //3, 1
        System.out.println(ListNode.toString(r.removeZeroSumSublists(ListNode.toList(new int[]{1, 2, 3, -3, 4})))); //1,2,4
        System.out.println(ListNode.toString(r.removeZeroSumSublists(ListNode.toList(new int[]{1, 2, 3, -3, -2}))));//1
        System.out.println(ListNode.toString(r.removeZeroSumSublists(ListNode.toList(new int[]{0, 2}))));//1
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        boolean foundSomething = false;
        ListNode newHead = head;

        while (!foundSomething) {

            ListNode curr = newHead;
            int sum = 0;
            map.clear();
            foundSomething = true;
            map.put(0, newHead);

            while (curr != null) {
                sum += curr.val;
                ListNode foundSum = map.get(sum); //To understand this logic search for SubArraySumOfK in this same repository and the method subArraySumOptimised.
                if (foundSum != null) {
                    if (sum == 0) {
                        newHead = curr.next;
                    } else {
                        foundSum.next = curr.next;
                    }
                    foundSomething = false;
                    break;//This can be improved by not breaking here and instead removing the sums from the map.
                }

                map.put(sum, curr);
                curr = curr.next;
            }
        }

        return newHead;
    }
}
