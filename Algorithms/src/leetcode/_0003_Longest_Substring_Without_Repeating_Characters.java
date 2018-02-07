/**
 *  @author  Yunxiang He
 *  @date    Dec 16, 2017 3:16:57 AM
 */

package leetcode;

import java.util.HashMap;

/*

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



*/

public class _0003_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        char[] _s = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i < _s.length; i++) {
            if (map.containsKey(_s[i])) {
                maxLength = Math.max(maxLength, i - index);
                index = map.get(_s[i]) < index ? index : map.get(_s[i]) + 1;
            }
            map.put(_s[i], i);
        }
        maxLength = Math.max(maxLength, s.length() - index);
        return maxLength == 0 ? s.length() : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbac"));
    }
}
