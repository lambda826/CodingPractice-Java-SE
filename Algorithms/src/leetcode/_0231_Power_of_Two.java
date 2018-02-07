/**
 *  @author  Yunxiang He
 *  @date    Jan 5, 2018 12:31:16 AM
 */

package leetcode;

/*

Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 */

public class _0231_Power_of_Two {

    /**
     * Solution:
     * Bit manipulation
     * --------------------------------------------------------------
     * Tips:
     * When n is less than or equal to, return false
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += n & 1;
            n >>= 1;
        }
        return sum == 1 ? true : false;
    }
}
