/**
 * @author Yunxiang He
 * @date Oct 11, 2017 2:33:01 AM
 */

package leetcode;

import java.util.Stack;

import leetcode.common.ListNode;

/*

Reverse a singly linked list.

 */

public class _0206_Reverse_Linked_List {

    /**
     * Optimal solution:
     * Pointer manipulation + iteration
     * --------------------------------------------------------------
     * Tips:
     * 2 pointers are needed, one for current node, one for previous node
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * Optimal solution:
     * Pointer manipulation + recursion
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(n)
     */
    public ListNode reverseListRecursion(ListNode head) {
        head = recursion(head, null);
        return head;
    }

    private ListNode recursion(ListNode curr, ListNode pre) {
        if (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = recursion(temp, curr);
        }
        return pre;
    }

    /**
     * Solution 2:
     * Stack
     * --------------------------------------------------------------
     * Tips:
     * Too slow
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(n)
     */
    public ListNode soluton2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode h = head;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode _h = h;
        while (stack.size() > 0) {
            h.val = stack.pop();
            h = h.next;
        }
        return _h;
    }

    //    public ListNode reverseList(ListNode head) {
    //        Stack<ListNode> stack = new Stack<ListNode>();
    //        while (head != null) {
    //            stack.push(head);
    //            head = head.next;
    //        }
    //        ListNode l = new ListNode(0);
    //        head = l;
    //        while (stack.size() > 0) {
    //            l.next = stack.pop();
    //            l = l.next;
    //        }
    //        return head.next;
    //    }

    public static void main(String[] args) {
        _0206_Reverse_Linked_List test = new _0206_Reverse_Linked_List();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(22);
        ListNode l3 = new ListNode(333);
        l1.next = l2;
        l2.next = l3;
        System.out.println(test.reverseListRecursion(l1).val);

    }
}
