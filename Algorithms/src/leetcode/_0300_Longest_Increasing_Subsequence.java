/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:28:58 AM
 */

package leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.text.html.HTML.Tag;

/*

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n^2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 */

public class _0300_Longest_Increasing_Subsequence {
    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(n)
     */
    public int lengthOfLIS_BinarySearch(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            binarySearch(list, nums[i]);
        }
        return list.size();
    }

    private void binarySearch(ArrayList<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (list.get(lo) < target) {
            list.add(target);
        } else {
            list.set(lo, target);
        }
    }

    /**
     * Solution:
     * DP
     * --------------------------------------------------------------
     *  Time complexity : O(nn)
     * Space complexity : O(n)
     */
    public int lengthOfLIS_DP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = 1;
            int maxL = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxL = Math.max(maxL, arr[j] + 1);
                }
            }
            arr[i] = maxL;
            maxLength = Math.max(maxLength, maxL);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
        _0300_Longest_Increasing_Subsequence test = new _0300_Longest_Increasing_Subsequence();
        System.out.println(test.lengthOfLIS_DP(nums));
        System.out.println(test.lengthOfLIS_BinarySearch(nums));
    }
}
