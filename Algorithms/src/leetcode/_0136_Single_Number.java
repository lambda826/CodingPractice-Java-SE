/**
 *  @author  Yunxiang He
 *  @date    Jan 3, 2018 4:06:52 PM
 */

package leetcode;

/*

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

 */

public class _0136_Single_Number {
    /**
     * Solution:
     * XOR manipulation
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
