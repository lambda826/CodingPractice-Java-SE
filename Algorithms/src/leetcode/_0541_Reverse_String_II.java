/**
 *  @author  Yunxiang He
 *  @date    Dec 21, 2017 9:22:20 PM
 */

package leetcode;

/*

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 
If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

*/

public class _0541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        if (k == 0)
            return s;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i = i + 2 * k) {
            reverse(c, i, i + k - 1);
        }
        return new String(c);
    }

    private void reverse(char[] c, int start, int end) {
        if (end > c.length - 1)
            end = c.length - 1;
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _0541_Reverse_String_II().reverseStr("abcde", 2));
    }
}
