/**
 *  @author  Yunxiang He
 *  @date    Dec 18, 2017 5:47:58 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

public class _0021_Merge_Two_Sorted_Lists {

    // recursion
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // iteration
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res = new ListNode(0);
        ListNode l = res;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (v1 > v2) {
                l.next = l2;
                l2 = l2.next;
            } else {
                l.next = l1;
                l1 = l1.next;
            }
            l = l.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(5);
        ListNode l23 = new ListNode(6);
        l21.next = l22;
        l22.next = l23;

        mergeTwoLists(l11, l21);
    }
}
