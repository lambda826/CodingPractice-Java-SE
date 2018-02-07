/**
 *  @author  Yunxiang He
 *  @date    Dec 23, 2017 10:52:53 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4

*/

public class _0369_Plus_One_Linked_List {

    // Recursion
    public ListNode plusOne(ListNode head) {
        ListNode res = new ListNode(1);
        head = plusOneAux(head);
        if (head.val == 10) {
            head.val = 0;
            res.next = head;
            return res;
        }
        return head;
    }

    private ListNode plusOneAux(ListNode head) {
        if (head.next == null) {
            head.val += 1;
            return head;
        }
        ListNode l = plusOneAux(head.next);
        head.next = l;
        if (l.val == 10) {
            l.val = 0;
            head.val += 1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode l1 = new ListNode(9);
        head.next = l1;
        //    	ListNode l2 = new ListNode(9);
        //    	l1.next = l2;
        //    	ListNode l3 = new ListNode(9);
        //    	l2.next = l3;
        ListNode listNode = new _0369_Plus_One_Linked_List().plusOne(head);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}
