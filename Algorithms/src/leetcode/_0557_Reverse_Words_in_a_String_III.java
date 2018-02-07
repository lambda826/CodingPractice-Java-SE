/**
 *  @author  Yunxiang He
 *  @date    Dec 21, 2017 10:21:16 PM
 */

package leetcode;

/*

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.

*/

public class _0557_Reverse_Words_in_a_String_III {

    // record two pointers of the substrings
    // one for the left, and one for the right
    // once encounter a whitespace, reverse the substring
    // trick: don't forget to reverse the last substring
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j < c.length) {
            if (c[j] == ' ') {
                reverse(c, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(c, i, j - 1);
        return new String(c);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

    // running time is too long
    public String reverseWords1(String s) {
        String[] _s = s.split(" ");
        String res = "";
        for (String ss : _s) {
            res += new StringBuilder(ss).reverse().toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _0557_Reverse_Words_in_a_String_III().reverseWords("Let's take LeetCode contest"));
    }
}
