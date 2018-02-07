/**
 * @author Yunxiang He
 * @date Oct 6, 2017 3:23:50 PM
 */

package leetcode;

/*

Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

 */

public class _0005_Longest_Palindromic_Substring {

    /**
     * Optimal solution:
     * One loop to find the maxLength of centered at each character
     * --------------------------------------------------------------
     *  Time complexity : O(n * maxLength)
     * Space complexity : O(1)
     */
    private int left = 0;
    private int maxLength = 1;

    public String longestPalindrome(String s) {
        if (s == "")
            return "";
        char[] _s = s.toCharArray();
        for (int i = 0; i < _s.length; i++) {
            setMaxLength(i, _s);
        }
        return s.substring(left, left + maxLength);
    }

    private void setMaxLength(int start, char[] _s) {
        int end = start;
        while (end + 1 < _s.length && _s[start] == _s[end + 1]) {
            end++;
        }

        while (start - 1 >= 0 && end + 1 < _s.length && _s[start - 1] == _s[end + 1]) {
            start--;
            end++;
        }
        int temp = end - start + 1;
        if (temp > maxLength) {
            maxLength = temp;
            left = start;
        }
    }

    public static void main(String[] args) {
        _0005_Longest_Palindromic_Substring test = new _0005_Longest_Palindromic_Substring();
        System.out.println(test.longestPalindrome("caba"));
    }
}
