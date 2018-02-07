/**
 *  @author  Yunxiang He
 *  @date    Dec 11, 2017 3:24:05 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

*/

public class _0170_Two_Sum_III_Data_structure_design {
    private List<Integer> nums;

    /** Initialize your data structure here. */
    public _0170_Two_Sum_III_Data_structure_design() {
        this.nums = new ArrayList<Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find1(int value) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < value)
                left++;
            else if (sum > value)
                right--;
            else
                return true;
        }
        return false;
    }

    public boolean find2(int value) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            if (list.contains(k)) {
                return true;
            } else {
                list.add(value - k);
            }
        }
        return false;
    }

    public boolean find3(int value) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            if (map.containsKey(k)) {
                return true;
            } else {
                map.put(value - k, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _0170_Two_Sum_III_Data_structure_design test = new _0170_Two_Sum_III_Data_structure_design();
        test.add(1);
        test.add(3);
        test.add(5);
    }
}
