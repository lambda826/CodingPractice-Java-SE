/**
 * @author Yunxiang He
 * @date Oct 12, 2017 4:52:25 AM
 */

package leetcode;

public class _0344_Reverse_String {
    // 2 pointers : header and rear
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int h = 0;
        int r = c.length - 1;
        while (h < r) {
            char temp = c[h];
            c[h] = c[r];
            c[r] = temp;
            h++;
            r--;
        }
        return new String(c);
    }
}
