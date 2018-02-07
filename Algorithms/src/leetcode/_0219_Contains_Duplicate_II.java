/**
 /**
 *  @author  Yunxiang He
 *  @date    Dec 17, 2017 6:38:39 AM
 */

package leetcode;

import java.util.HashMap;

/*

Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array 
such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

*/

public class _0219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i])) <= k) {
                    res = true;
                    break;
                }
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
