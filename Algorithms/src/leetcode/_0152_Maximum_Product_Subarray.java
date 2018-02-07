/**
 *  @author  Yunxiang He
 *  @date    Jan 10, 2018 4:42:59 PM
 */

package leetcode;

/*

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

 */

public class _0152_Maximum_Product_Subarray {

    /**
     * Solution:
     * DP
     * --------------------------------------------------------------
     * Steps:
     * Because it is to compute product
     * So we need to record min value and max value
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            // There might be some zeros, the current max needs to be recorded in every iteration
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        _0152_Maximum_Product_Subarray test = new _0152_Maximum_Product_Subarray();
        int[] nums = { 2, -5, -4, 0, 3 };
        System.out.println(test.maxProduct(nums));
    }
}
