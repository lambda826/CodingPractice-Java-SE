/**
 *  @author  Yunxiang He
 *  @date    Dec 18, 2017 2:43:46 AM
 */

package leetcode;

/*

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

*/

public class _0238_Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int x = 1;
        for (int i = 0; i < n - 1; i++) {
            x *= nums[i];
            res[i + 1] = x;
        }
        x = 1;
        for (int i = n - 1; i > 0; i--) {
            x *= nums[i];
            res[i - 1] = x * res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int x : productExceptSelf(new int[] { 1, 2, 3, 4 })) {
            System.out.println(x);
        }
    }
}
