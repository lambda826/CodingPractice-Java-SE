/**
 *  @author  Yunxiang He
 *  @date    Oct 5, 2017 12:58:30 PM
 */
package leetcode;

/*

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. 
However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
How would you handle such case?

There is a more generic way of solving this problem.

*/

public class _0009_Palindrome_Number {

    /**
     * Solution 1:
     * Reverse the number
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 10) {
            if (x < 0)
                return false;
            else
                return true;
        }
        int rev = 0;
        int num = x;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == num;
    }

    public static void main(String[] args) {
        _0009_Palindrome_Number test = new _0009_Palindrome_Number();
        System.out.println(test.isPalindrome(990));
        System.out.println(test.isPalindrome(9909));
        System.out.println(test.isPalindrome(99099));
    }
}
