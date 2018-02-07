/**
 *  @author  Yunxiang He
 *  @date    Dec 19, 2017 8:11:22 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

 */

public class _0203_Remove_Linked_List_Elements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head.val == val) {
            head = head.next;
            if (head == null)
                return null;
        }
        head.next = removeElements(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        //		ListNode l3 = new ListNode(3);
        l1.next = l2;
        //		l2.next = l3;

        removeElements(l1, 1);
    }
}
