/**
 *  @author  Yunxiang He
 *  @date    Jan 19, 2018 7:03:39 PM
 */

package leetcode;

import leetcode.common.TreeNode;

/*

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

 */

public class _0222_Count_Complete_Tree_Nodes {

    /**
     * Optimal solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n * log n)
     * Space complexity : O(1)
     */
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int depth = -1;
        TreeNode _root = root;
        while (_root != null) {
            depth++;
            _root = _root.left;
        }
        if (0 == depth) {
            return 1;
        }
        int count = (1 << depth + 1) - 1;
        while (depth > 1) {
            if (hasMidNode(root, depth)) {
                root = root.right;
            } else {
                root = root.left;
                count -= 1 << depth - 1;
            }
            depth--;
        }
        return root.left == null ? count - 2 : root.right == null ? count - 1 : count;
    }

    private boolean hasMidNode(TreeNode root, int depth) {
        root = root.left;
        depth--;
        while (depth > 0) {
            root = root.right;
            depth--;
        }
        return root != null ? true : false;
    }

    /**
     * Solution 2:
     * Recursion
     */
    public int solution2(TreeNode root) {
        int depth = -1;
        TreeNode _root = root;
        while (_root != null) {
            depth++;
            _root = _root.left;
        }
        return depth == 0 ? 1 : computeNodes(root, depth);
    }

    private int computeNodes(TreeNode root, int depth) {
        if (0 != depth) {
            if (computeRightDepth(root) == depth) {
                return (1 << depth + 1) - 1;
            } else {
                TreeNode leftNode = root.left;
                if (depth - 1 == computeRightDepth(leftNode)) {
                    return (1 << depth) + computeNodes(root.right, depth - 1);
                } else {
                    return (1 << depth - 1) + computeNodes(root.left, depth - 1);
                }
            }
        } else {
            return 0;
        }
    }

    private int computeRightDepth(TreeNode root) {
        int depth = -1;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }

}
