/**
 *  @author  Yunxiang He
 *  @date    Jan 6, 2018 4:31:40 PM
 */

package leetcode;

import leetcode.common.TreeNode;

/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

*/

public class _0104_Maximum_Depth_of_Binary_Tree {

    /**
     * Solution:
     * Recurrence
     * --------------------------------------------------------------
     *  Time complexity : O(Depth)
     * Space complexity : O(1)
     */
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
        }
        return 0;
    }
}
