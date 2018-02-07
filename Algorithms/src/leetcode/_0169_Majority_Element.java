/**
 *  @author  Yunxiang He
 *  @date    Dec 16, 2017 4:07:40 AM
 */

package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

public class _0169_Majority_Element {

    /**
     * Optiaml olution:
     * Sort + math
     * --------------------------------------------------------------
     * Steps:
     * The ided is that the majority is across the mid of the sorted array
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Solution 2:
     * Hashmap
     * --------------------------------------------------------------
     *  Time complexity : O(n * operation on hashmap)
     * Space complexity : O(n)
     */
    public int solution2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > nums.length / 2) {
                res = x;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0169_Majority_Element test = new _0169_Majority_Element();
        test.solution2(new int[] { 3, 2, 3 });
    }
}
