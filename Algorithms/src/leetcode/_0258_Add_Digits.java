/**
 *  @author  Yunxiang He
 *  @date    Jan 8, 2018 2:28:25 PM
 */

package leetcode;

/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 */

public class _0258_Add_Digits {

    /**
     * Solution:
     * Mathematics
     * --------------------------------------------------------------
     * Steps:
     * 438 = 400 + 30 + 8
     * 400 % 9 = 4; 30 % 9 = 3; 8 % 9 = 8
     * --------------------------------------------------------------
     *  Time complexity : O(1)
     * Space complexity : O(1)
     */
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}
