/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:29:35 AM
 */

package leetcode;

import java.util.ArrayList;

/*

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 */

public class _0392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (char c : s.toCharArray()) {
            start = t.indexOf(c, start) + 1;
            if (start == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     
    Follow up:
    If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
    and you want to check one by one to see if T has its subsequence. 
    In this scenario, how would you change your code?
     
     */

    public boolean isSubsequenceFollowUp(String s, String t) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] container = new ArrayList[26];
        char[] _t = t.toCharArray();
        for (int i = 0; i < _t.length; i++) {
            int k = _t[i] - 'a';
            if (container[k] == null) {
                container[k] = new ArrayList<Integer>();
            }
            container[k].add(i);
        }

        char[] _s = s.toCharArray();

        boolean res = true;
        int index = 0;
        for (int i = 0; i < _s.length; i++) {
            ArrayList<Integer> list = container[_s[i] - 'a'];
            if (list == null) {
                res = false;
                break;
            } else {
                index = binarySearch(container[_s[i] - 'a'], index);
                if (-1 == index) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    private int binarySearch(ArrayList<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == list.get(mid)) {
                return list.get(mid) + 1;
            } else if (target < list.get(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (hi >= list.size()) {
            return -1;
        } else {
            return list.get(hi) + 1;
        }
    }

    public static void main(String[] args) {
        _0392_Is_Subsequence test = new _0392_Is_Subsequence();
        System.out.println(test.isSubsequenceFollowUp("abgdccchc", "ahbgdcccc"));
    }
}
