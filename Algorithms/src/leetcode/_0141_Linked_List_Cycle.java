/**
 *  @author  Yunxiang He
 *  @date    Jan 7, 2018 6:34:06 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 */

public class _0141_Linked_List_Cycle {

    /**
     * Solution:
     * Fast + slow pointers
     * --------------------------------------------------------------
     * Steps:
     * The speed of fast pointer is twice as slow's
     * If they can meet, there is cycle of the linkedlist
     * --------------------------------------------------------------
     * Tips:
     * This is not comparing the value of the linkedlist
     * Instead, it's the reference
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
