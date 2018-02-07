
/**
 *  @author  Yunxiang He
 *  @date    Dec 23, 2017 8:17:45 AM
 */

package leetcode;

import java.util.Stack;

import leetcode.common.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

*/

public class _0445_Add_Two_Numbers_II {

    // Use a stack
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode h1 = new ListNode(0);
        int sum = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            sum = (s1.size() > 0 ? s1.pop() : 0) + (s2.size() > 0 ? s2.pop() : 0) + h1.val;
            ListNode h2 = new ListNode(sum / 10);
            h1.val = sum % 10;
            h2.next = h1;
            h1 = h2;
        }
        return h1.val == 0 ? h1.next : h1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        l1.next = l2;
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(2);
        l3.next = l4;
        ListNode l5 = new ListNode(9);
        l4.next = l5;

        ListNode res = new _0445_Add_Two_Numbers_II().addTwoNumbers(l1, l3);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
