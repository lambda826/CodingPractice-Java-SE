/**
 *  @author  Yunxiang He
 *  @date    Dec 17, 2017 6:34:05 AM
 */

package leetcode;

import java.util.HashSet;

/*

Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

*/

public class _0217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (set.add(x))
                return true;
        }
        return false;
    }
}
