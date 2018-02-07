/**
 *  @author  Yunxiang He
 *  @date    Jan 14, 2018 6:27:55 PM
 */

package leetcode;

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. 
If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

 */

public class _0033_Search_in_Rotated_Sorted_Array {

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     * Tips:
     * Rotated sorted array, at least one of the left or right half is sorted
     * --------------------------------------------------------------
     * Corner case:
     * nums.length = 0;
     * nusm.length = 1;
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else {
                if (nums[lo] <= nums[mid]) {
                    if (target < nums[lo] || target > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    if (target < nums[mid] || target > nums[hi]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _0033_Search_in_Rotated_Sorted_Array test = new _0033_Search_in_Rotated_Sorted_Array();
        int[] nums = {};
        System.out.println(test.search(nums, 3));
    }
}
