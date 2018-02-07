/**
 *  @author  Yunxiang He
 *  @date    Dec 17, 2017 11:43:59 PM
 */

package leetcode;

import java.util.HashMap;

/*

Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

*/

public class _0220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        boolean f = !(t == 0);
        t = f ? t : 1;
        for (int i = 0; i < nums.length; i++) {
            long n = (((long) nums[i]) + Integer.MAX_VALUE) / t;
            if (map.containsKey(n))
                return true;
            if (map.containsKey(n - 1) && f) {
                if (Math.abs(map.get(n - 1) - nums[i]) <= t)
                    return true;
            }
            if (map.containsKey(n + 1) && f) {
                if (Math.abs(map.get(n + 1) - nums[i]) <= t)
                    return true;
            }
            if (i >= k) {
                Long key = (((long) nums[i - k]) + Integer.MAX_VALUE) / t;
                map.remove(key);
            }
            map.put(n, nums[i]);
        }
        return false;
    }
}
