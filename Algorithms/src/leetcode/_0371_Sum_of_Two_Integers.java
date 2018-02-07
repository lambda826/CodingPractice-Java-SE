/**
 *  @author  Yunxiang He
 *  @date    Dec 14, 2017 6:46:20 PM
 */

package leetcode;

/*

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Credits:
Special thanks to @fujiaozhu for adding this problem and creating all test cases.

*/

public class _0371_Sum_of_Two_Integers {

    // compute carry by a & b << 1 (1 & 1 = 1, 1 << 1 = 10)
    // compute sum by a ^ b (1 ^ 0 = 1, 0 ^ 1 = 1)
    public int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
