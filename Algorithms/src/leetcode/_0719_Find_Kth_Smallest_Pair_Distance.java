/**
 *  @author  Yunxiang He
 *  @date    Dec 29, 2017 2:12:39 AM
 */

package leetcode;

import java.util.Arrays;

/*

Given an integer array, return the k-th smallest distance among all the pairs. 
The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 

Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2

Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

 */

public class _0719_Find_Kth_Smallest_Pair_Distance {

    /**
     * Optimal solution:
     * Binary search + sliding window
     * --------------------------------------------------------------
     * Steps:
     * Sort the input array (O(n log n))
     * Binary serach to guess the kth possible smallest distance (O(log n))
     * Sliding window to find the number that is larger than the guess number (O(n))
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int i = 0;
            // Sliding window
            for (int j = 1; j < nums.length; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * Solution 2: 
     * Brutal force + bucket sort
     * --------------------------------------------------------------
     * Steps:
     * Sort the input array, get the maximum distance
     * Compute all distances of every pair,
     * Record distances in the corresponding bucket
     * --------------------------------------------------------------
     *  Time complexity : O(n ^ n)
     * Space complexity : O(n)
     */
    public int solution2(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums[nums.length - 1];
        int[] buckets = new int[N + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                buckets[nums[j] - nums[i]]++;
            }
        }
        int count = 0;
        int i = 0;
        while (count < k) {
            count += buckets[i];
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(new _0719_Find_Kth_Smallest_Pair_Distance().smallestDistancePair(new int[] { 1, 4, 5, 100, 999, 1000 }, 3));
    }
}
