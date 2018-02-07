/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 12:38:29 AM
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

 */

public class _0349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int x : nums1) {
            set.add(x);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] _res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            _res[i] = res.get(i);
        }
        return _res;
    }
}
