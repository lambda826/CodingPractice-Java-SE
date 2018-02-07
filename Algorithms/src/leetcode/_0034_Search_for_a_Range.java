/**
 *  @author  Yunxiang He
 *  @date    Jan 21, 2018 3:31:32 PM
 */

package leetcode;

/*

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 */

public class _0034_Search_for_a_Range {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int left = -1;
        int right = -1;
        int startIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                startIndex = mid;
                break;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (-1 != startIndex) {
            left = findLeftIndex(startIndex, nums, target);
            right = findRightIndex(startIndex, nums, target);
            return new int[] { left, right };
        } else {
            return new int[] { -1, -1 };
        }
    }

    private int findLeftIndex(int startIndex, int[] nums, int target) {
        int lo = 0;
        int hi = startIndex;
        do {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        } while (lo <= hi);
        return lo;
    }

    private int findRightIndex(int startIndex, int[] nums, int target) {
        int lo = startIndex;
        int hi = nums.length - 1;
        do {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } while (lo <= hi);
        return lo - 1;
    }

    public static void main(String[] args) {
        _0034_Search_for_a_Range test = new _0034_Search_for_a_Range();
        test.searchRange(new int[] { 2, 2 }, 2);
    }
}
