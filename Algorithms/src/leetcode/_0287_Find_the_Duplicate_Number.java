/**
 *  @author  Yunxiang He
 *  @date    Jan 4, 2018 12:37:26 AM
 */

package leetcode;

/*

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n ^ 2).
There is only one duplicate number in the array, but it could be repeated more than once.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 */

public class _0287_Find_the_Duplicate_Number {

    /**
     * Optimal solution:
     * Slow & fast pointers, find the start point of the circle
     * --------------------------------------------------------------
     * Steps:
     * Find the start of the circle
     * Find the same elements in the circle
     * --------------------------------------------------------------
     * Tips:
     * First, we can map the index to the element in the array
     *     For example, [0, 1, 2, 3] -> [2, 4, 1, 3], 0 -> 2, 1 -> 4, 2 -> 1, 3 -> 3
     * If there is no duplicate element in the array, then the mapping is one-to-one 
     *     Then we can go throw the array without any circle
     *     Start from index 0) -> 2 -> 1 -> 4
     * If there is a duplicate element in the array, then at least, there are two indices mapping to one same element
     *     For example, [0, 1, 2, 3, 4] -> [2, 4, 1, 3, 1], [2, 4] -> 1)
     *     Then there will be a circle in the path, (start from index 0) -> 2 -> 1 -> 4 -> 1 -> 4 -> ...
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // Get the met point of the two pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Reason we need to set the res to zero again:
        // 1. Set x1 to be the length which is not part of the circle
        // 2. Set x2 to be the length which is slow pointer walks in the circle
        // 3. Then when the two pointer meets, the path length of the slow point is x1 + x2
        // 4. Then path length of the fast point is x1 + x2 + c(length of the circle)
        // 5. Because the speed of the fast is 2 times of the slow, we have 2(x1 + x2) = x1 + x2 + c
        // 6. Then c = x1 + x2  =>  c - x2 = x1
        // 7. x1 is the length before enterring the circle, c - x2 is the length the meet point from the start point of the circle.
        // 8. Those two are equal, which leads to setting the start point to zero, and set the two point to the same speed
        // 9. When they first meet, this meet point will be the start piont of the circle, which is the multiple mapping to the same number
        int res = 0;
        while (res != slow) {
            slow = nums[slow];
            res = nums[res];
        }
        return res;
    }

    /**
     * Solution 2:
     * Binary search
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int solution2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int count = 0;
            int mid = lo + (hi - lo) / 2;
            // Count the number of the elements in the arrary is less than or equal to mid
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            // If the number is greater than mid, search in the left
            // For example 1, 1, 1, 1, 5, 6, 7, 8,8
            // Mid = (1 + 9) / 2 = 5
            // If there are exactly 5 element that 
            if (count > mid) {
                hi = mid;
            } else
                lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
        _0287_Find_the_Duplicate_Number test = new _0287_Find_the_Duplicate_Number();
        System.out.println(test.findDuplicate(nums));
    }
}
