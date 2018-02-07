/**
 *  @author  Yunxiang He
 *  @date    Jan 4, 2018 11:37:26 PM
 */

package leetcode;

/*

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

 */

public class _0191_Number_of_1_Bits {

    /**
     * Solution:
     * Bit manipulation
     * --------------------------------------------------------------
     * Steps:
     * AND 1 to check whether the current bit is 1
     * Right shit
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
