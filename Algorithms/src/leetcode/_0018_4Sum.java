/**
 * @author Yunxiang He
 * @date Dec 11, 2017 12:20:54 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 */

public class _0018_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> resList = new ArrayList<>();

        for (int k = 0; k < nums.length - 3; k++) {
            int _target = target - nums[k];
            if (k > 0 && nums[k - 1] == nums[k])
                continue;
            for (int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1])
                    continue;

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] < _target) {
                        left++;
                    } else if (nums[i] + nums[left] + nums[right] > _target) {
                        right--;
                    } else {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[k]);
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        resList.add(l);
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, -2, -5, -4, -3, 3, 3, 5 };
        int target = -11;
        List<?> resList = fourSum(nums, target);
        System.out.println(resList);

    }

}
