/**
 *  @author  Yunxiang He
 *  @date    Jan 22, 2018 3:42:32 PM
 */

package leetcode;

/*

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

 */

public class _0081_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return true;
            } else {
                if (nums[mid] < nums[hi]) {
                    if (target > nums[hi] || target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else if (nums[mid] > nums[hi]) {
                    if (target < nums[lo] || target > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    hi--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        int target = 1;
        _0081_Search_in_Rotated_Sorted_Array_II test = new _0081_Search_in_Rotated_Sorted_Array_II();
        boolean result = test.search(nums, target);
        System.out.println(result);
    }
}
