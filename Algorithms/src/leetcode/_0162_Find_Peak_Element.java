/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 6:51:50 PM
 */

package leetcode;

/*

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

 */

public class _0162_Find_Peak_Element {

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((mid >= nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid <= 0 || nums[mid] > nums[mid - 1])) {
                return mid;
            } else if (mid <= 0 || nums[mid] > nums[mid - 1]) {
                lo = mid + 1;
            } else if (mid >= nums.length - 1 || nums[mid] > nums[mid + 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        _0162_Find_Peak_Element test = new _0162_Find_Peak_Element();
        int[] nums = { 2, 1, 2 };
        System.out.println(test.findPeakElement(nums));
    }
}
