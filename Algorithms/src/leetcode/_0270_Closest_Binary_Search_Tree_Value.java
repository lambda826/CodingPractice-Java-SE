/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 3:40:43 PM
 */

package leetcode;

import leetcode.common.TreeNode;

/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.


 */

public class _0270_Closest_Binary_Search_Tree_Value {

    /**
     * Solution:
     * Tree
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int closestValue(TreeNode root, double target) {
        Double min = Double.MAX_VALUE;
        while (root != null) {
            min = Math.min(min, root.val - target);
            if (0 == min) {
                break;
            } else if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return (int) (target - min);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
