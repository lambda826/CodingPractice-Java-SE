/**
 *  @author  Yunxiang He
 *  @date    Dec 11, 2017 4:47:35 PM
 */

package leetcode;

/*

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

*/

public class _0066_Plus_One {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // if the digit is less than 9,
            // then there won't carry anymore,
            // could return the value
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 1000 = 999 + 1
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

}
