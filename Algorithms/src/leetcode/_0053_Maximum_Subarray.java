/**
 *  @author  Yunxiang He
 *  @date    Dec 16, 2017 8:07:05 PM
 */

package leetcode;

/*

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

public class _0053_Maximum_Subarray {

    // O(n)
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 0 && sum < 0) {
                sum = nums[i];
            } else
                sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Divide and Conquer
    // O(n log n)
    public static int maxSubArray2(int[] nums) {
        return maximumSubArray(0, nums.length - 1, nums);
    }

    private static int maximumSubArray(int low, int high, int[] nums) {
        if (low == high) {
            return nums[low];
        }
        int mid = (low + high) / 2;
        int leftMax = maximumSubArray(low, mid, nums);
        int rightMax = maximumSubArray(mid + 1, high, nums);
        int crossMax = maxCrossMid(low, high, mid, nums);

        if (leftMax >= rightMax && leftMax >= crossMax)
            return leftMax;
        else if (rightMax >= leftMax && rightMax >= crossMax)
            return rightMax;
        else {
            return crossMax;
        }
    }

    private static int maxCrossMid(int low, int high, int mid, int nums[]) {
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        for (int i = mid + 1; i <= high; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        // output: 33
        // System.out.println(maxSubArray(new int[] { 13, -3, -25, 20, -3, -16, -23, 18,
        // 20, -7, 12, -5, -22, 15, -4, 7 }));
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

}
