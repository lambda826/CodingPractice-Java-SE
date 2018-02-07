/**
 *  @author  Yunxiang He
 *  @date    Jan 3, 2018 11:59:13 PM
 */

package leetcode;

/*

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2
Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 */

public class _0268_Missing_Number {

    /**
     * Optimal solution:
     * Math
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

    /**
     * Solution:
     * Bit manipulation
     * --------------------------------------------------------------
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int solution2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int i = 0;
        while (i <= nums.length) {
            res ^= i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        _0268_Missing_Number test = new _0268_Missing_Number();
        int[] nums = new int[] { 0, 1, 2, 3, 4, 5, 7 };
        System.out.println(test.missingNumber(nums));
        System.out.println(test.solution2(nums));
    }
}
