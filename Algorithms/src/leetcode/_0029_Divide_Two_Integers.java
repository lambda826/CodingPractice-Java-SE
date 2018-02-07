/**
 *  @author  Yunxiang He
 *  @date    Jan 16, 2018 7:03:28 PM
 */

package leetcode;

/*

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

 */

public class _0029_Divide_Two_Integers {

    /**
     * Solution:
     * Math
     * --------------------------------------------------------------
     * Corner Case:
     * dividend < 0; divisor < 0;
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if (dividend > 0 && divisor > 0)
            return divideAux(-dividend, -divisor);
        else if (dividend > 0)
            return -divideAux(-dividend, divisor);
        else if (divisor > 0)
            return -divideAux(dividend, -divisor);
        else
            return divideAux(dividend, divisor);
    }

    private int divideAux(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int count = 0;
        int _divisor = divisor;
        // _divisor << 1 < 0 is used to avoid overflow of rightshift
        while (dividend < _divisor << 1 && _divisor << 1 < 0) {
            _divisor <<= 1;
            count++;
        }
        return (1 << count) + divideAux(dividend - _divisor, divisor);
    }

    public static void main(String[] args) {
        _0029_Divide_Two_Integers test = new _0029_Divide_Two_Integers();
        int dividend = Integer.MAX_VALUE;
        int divisor = 3;
        System.out.println(test.divide(dividend, divisor));
        System.out.println(dividend / divisor);

    }
}
