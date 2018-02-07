/**
 *  @author  Yunxiang He
 *  @date    Jan 9, 2018 7:34:56 PM
 */

package leetcode;

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

 */

public class _0153_Find_Minimum_in_Rotated_Sorted_Array {

    /**
     * Solution:
     * Binary search
     * --------------------------------------------------------------
     * Steps:
     * Every time, eliminate half of the rest array
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = { 5, 6, 7, 8, 9, 11, 1, 2, 3, 4 };
        _0153_Find_Minimum_in_Rotated_Sorted_Array test = new _0153_Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(test.findMin(nums));
    }
}
