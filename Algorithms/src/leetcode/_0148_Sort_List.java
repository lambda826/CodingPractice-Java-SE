/**
 * @author Yunxiang He
 * @date Oct 9, 2017 4:28:42 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

public class _0148_Sort_List {

    /**
     * Solution:
     * Merge sort
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = divide(head);
        ListNode mid_ = mid.next;
        // Here need to cut the list off
        mid.next = null;
        return mergeAux(sortList(head), sortList(mid_));
    }

    private ListNode divide(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeAux(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeAux(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeAux(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        _0148_Sort_List test = new _0148_Sort_List();
        ListNode n1 = new ListNode(11);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(14);
        ListNode n4 = new ListNode(13);
        ListNode n5 = new ListNode(12);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = test.sortList(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
