/**
 * @author Yunxiang He
 * @date Oct 11, 2017 1:55:52 AM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 */

// 
public class _0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 从小打到排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        // 因为 a + b + c = 0， 当 a > 0 结束循环
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 如果当前指针所指元素和上一次迭代相同，则忽略当前迭代
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 以当前指针为锚点，遍历左右元素和
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 和小于零，左指针右移
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    // 和大于零，右指针左移
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    // 如果左指针的下一个元素和当前元素相同，左指针继续右移
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 如果右指针的下一个元素和当前元素相同，左指针继续左移
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new _0015_3Sum().threeSum(new int[] { 0, 0, 0 });
    }
}
