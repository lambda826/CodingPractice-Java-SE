/**
 *  @author  Yunxiang He
 *  @date    Jan 6, 2018 3:54:55 PM
 */

package leetcode;

/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output:  321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */

public class _0007_Reverse_Integer {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev > 0 && (rev > (Integer.MAX_VALUE - x % 10) / 10))
                return 0;
            else if (rev < 0 && rev < (Integer.MIN_VALUE - x % 10) / 10)
                return 0;
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        _0007_Reverse_Integer test = new _0007_Reverse_Integer();
        System.out.println(test.reverse(-123099));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
