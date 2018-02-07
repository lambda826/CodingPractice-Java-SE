/**
 *  @author  Yunxiang He
 *  @date    Dec 22, 2017 4:22:27 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/

public class _0002_Add_Two_Numbers {

    // Iteration
    // Use a head pointer to point the linked list that we need to return
    // The ListNode is the headPointer.next
    // If either of the parameter ListNode is null, then assign it to be null in the next iteration
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode resLst = temp;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            ListNode l0 = null;
            if (sum < 10) {
                l0 = new ListNode(sum);
                carry = 0;
            } else {
                l0 = new ListNode(sum % 10);
                carry = 1;
            }

            temp.next = l0;
            temp = l0;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return resLst.next;
    }

    // Recursion
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = plus(null, l1, l2, 0);
        return root;
    }

    private ListNode plus(ListNode previous, ListNode l1, ListNode l2, int carry) {
        if (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = (v1 + v2) % 10;
            ListNode current = new ListNode(val + carry);
            if (previous != null) {
                previous.next = current;
            } else {
                previous = current;
            }
            carry = (v1 + v2) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            plus(current, l1, l2, carry);
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l2.next = l3;
        ListNode res = new _0002_Add_Two_Numbers().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
