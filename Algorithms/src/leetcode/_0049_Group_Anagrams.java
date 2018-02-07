/**
 *  @author  Yunxiang He
 *  @date    Jan 11, 2018 5:22:00 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.

 */

public class _0049_Group_Anagrams {

    /**
     * Optmial solution:
     * Generate prime numbers
     * Use the multiplication as the key of hash
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String st : strs) {
            char[] str = st.toCharArray();
            int key = 1;
            for (int i = 0; i < str.length; i++) {
                key *= prime[str[i] - 'a'];
            }
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
                result.add(list);
                map.put(key, list);
            }
            list.add(st);
        }
        return result;
    }

    /**
     * Solution 2:
     * Sort every string of the input
     * Use it as the key of hash
     * --------------------------------------------------------------
     *  Time complexity : O(n ^ n log n)
     * Space complexity : O(1)
     */
    public List<List<String>> solution2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        _0049_Group_Anagrams test = new _0049_Group_Anagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        test.groupAnagrams(strs);
    }
}
