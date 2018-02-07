/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 3:16:00 AM
 */

package leetcode;

/*

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:
Input: 14
Returns: False

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

 */

public class _0367_Valid_Perfect_Square {

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int lo = 0;
        int hi = 46340;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int prod = mid * mid;
            if (prod == num) {
                return true;
            } else if (prod < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _0367_Valid_Perfect_Square test = new _0367_Valid_Perfect_Square();
        System.out.println(test.isPerfectSquare(2147483647));
    }
}
