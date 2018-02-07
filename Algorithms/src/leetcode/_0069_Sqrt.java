/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 5:04:04 AM
 */

package leetcode;

/*

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.


 */

public class _0069_Sqrt {

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int mySqrt(int x) {
        if (1 == x || 0 == x) {
            return x;
        }
        long lo = 1;
        long hi = x;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) (lo - 1);
    }

    public static void main(String[] args) {
        _0069_Sqrt test = new _0069_Sqrt();
        System.out.println(test.mySqrt(7));
    }
}
