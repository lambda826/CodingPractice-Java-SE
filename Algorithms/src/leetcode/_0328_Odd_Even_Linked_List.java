/**
 *  @author  Yunxiang He
 *  @date    Jan 11, 2018 9:18:29 PM
 */

package leetcode;

import leetcode.common.ListNode;

/*

Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. 
The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

Credits:
Special thanks to @DjangoUnchained for adding this problem and creating all test cases.

 */

public class _0328_Odd_Even_Linked_List {

    /**
     * Solution:
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenTemp = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenTemp;
        }
        return head;
    }

    public static void main(String[] args) {
        _0328_Odd_Even_Linked_List test = new _0328_Odd_Even_Linked_List();
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        test.oddEvenList(head);
    }
}
