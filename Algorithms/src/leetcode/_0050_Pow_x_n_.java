/**
 *  @author  Yunxiang He
 *  @date    Jan 11, 2018 10:20:11 PM
 */

package leetcode;

/*

Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100

 */

public class _0050_Pow_x_n_ {

    /**
     * Optimal solution:
     * Divide and conquer
     * --------------------------------------------------------------
     * Corner case:
     * n = 0;
     * n < 0;
     * n = -2147483648;
     * --------------------------------------------------------------
     * Tips:
     * if n = Interge.MIN_VALUE, then -n will overflow, but (-n - 1) won't overflow
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            return myPow(x, (-n - 1)) * x;
        } else {
            double y = myPow(x, n >> 1);
            return y * y * ((n & 1) == 1 ? x : 1);
        }
    }

    public static void main(String[] args) {
        _0050_Pow_x_n_ test = new _0050_Pow_x_n_();
        System.out.println(test.myPow(111, -12));
        System.out.println(Math.pow(111, -12));
        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(Integer.toBinaryString(min));
        //  -2147483648
        //  10000000000000000000000000000000
        System.out.println(-min);
        System.out.println(Integer.toBinaryString(-min));
        //  -2147483648
        //  10000000000000000000000000000000
        System.out.println(-min - 1);
        System.out.println(Integer.toBinaryString(-min - 1));
        //   2147483647
        //  01111111111111111111111111111111
    }

}
