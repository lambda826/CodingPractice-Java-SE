/**
 *  @author  Yunxiang He
 *  @date    Jan 7, 2018 6:45:33 PM
 */

package leetcode;

/*

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

 */

public class _0151_Reverse_Words_in_a_String {

    /**
     * Optimal solution:
     * Java String api
     * --------------------------------------------------------------
     * Tips:
     * String::isEmpty()
     * String::split()
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public String reverseWords(String s) {
        String[] _s = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = _s.length - 1; i >= 0; i--) {
            if (!_s[i].isEmpty()) {
                sb.append(_s[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Solution 2:
     * Seach from the tail
     * --------------------------------------------------------------
     * Steps:
     * Search from the end of the string
     * First find the end of a word
     * Then find the beginning of the word
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        s = " " + s;
        boolean isStart = false;
        boolean isEnd = true;
        int start = 0;
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ' ' && isStart)) {
                start = i + 1;
                isStart = false;
            } else if (s.charAt(i) != ' ' && isEnd) {
                end = i + 1;
                isEnd = false;
                isStart = true;
            }
            if (!isStart && !isEnd) {
                sb.append(s.substring(start, end) + " ");
                isStart = true;
                isEnd = true;
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        _0151_Reverse_Words_in_a_String test = new _0151_Reverse_Words_in_a_String();
        System.out.println(test.reverseWords("  bc   a   b "));
    }
}
