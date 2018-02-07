/**
 *  @author  Yunxiang He
 *  @date    Dec 17, 2017 6:30:15 AM
 */

package leetcode;

/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

public class _0283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter++;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < counter; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}
