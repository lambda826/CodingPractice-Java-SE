/**
 *  @author  Yunxiang He
 *  @date    Jan 6, 2018 1:18:52 AM
 */

package leetcode;

/*

Write a function to find the longest common prefix string amongst an array of strings.

 */

public class _0014_Longest_Common_Prefix {

    /**
     * Optimal solution:
     * String api, indexOf
     * --------------------------------------------------------------
     * Steps:
     * In every iteration, find the LCP between current LCP with current string, 
     * Update the LCP
     * --------------------------------------------------------------
     *  Time complexity : O(sum of the length of all strings)
     * Space complexity : O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
            i++;
        }
        return prefix;
    }

    /**
     * Solution 2:
     * Vertical scanning
     * --------------------------------------------------------------
     *  Time complexity : O(sum of the length of all strings)
     * Space complexity : O(1)
     */
    public String solution2(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int i = 0;
        outter: while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            int j = 1;
            while (j < strs.length) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    break outter;
                }
                j++;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    /**
     * Solution:
     * Divide and conquer
     * --------------------------------------------------------------
     *  Time complexity : O(sum of the length of all strings)
     * Space complexity : O(1)
     */
    public String solution3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        _0014_Longest_Common_Prefix test = new _0014_Longest_Common_Prefix();
        System.out.println(test.longestCommonPrefix(new String[] { "aaa", "abc", "abb" }));
    }
}
