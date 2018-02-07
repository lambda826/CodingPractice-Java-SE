/**
 * @author Yunxiang He
 * @date Dec 21, 2017 1:10:50 AM
 */

package leetcode;

/*
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * The median is 2.0 
 * 
 * Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 */

public class _0004_Median_of_Two_Sorted_Arrays {

    /*
     * corner case : nums1 = null or nums2 = null; method 1: obtain the half of the
     * smallest elements; then compute the median complexity : O(m + n);
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        boolean isOdd = ((m + n) & 1) == 1;
        int mid = l / 2;
        int[] nums = new int[mid + 1];
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i <= mid; i++) {
            if (n2 == n || n1 < m && nums1[n1] < nums2[n2]) {
                nums[i] = nums1[n1];
                n1++;
            } else {
                nums[i] = nums2[n2];
                n2++;
            }
        }

        if (isOdd) {
            return (double) nums[mid];
        } else {
            return (double) (nums[mid] + nums[mid - 1]) / 2;
        }

    }

    /*
     * corner case : nums1 = null or nums2 = null; 
     * method 2: based on Binary Search
     * complexity : O(log(min(m, n)));
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int k = nums1.length + nums2.length;
        int cutL = 0;
        int cutR = nums1.length;
        int cut1 = 0;
        int cut2 = 0;
        while (true) {
            cut1 = (cutL + cutR) / 2;
            cut2 = k / 2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                // odd
                if ((k & 1) == 1) {
                    return (double) Math.min(r1, r2);
                } else {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
            } else if (l1 > r2) {
                // need to decrease l1
                cutR = cut1 - 1;
            } else if (l2 > r1) {
                // need to increase l1
                cutL = cut1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _0004_Median_of_Two_Sorted_Arrays().findMedianSortedArrays2(new int[] { 2, 3, 4, 5 }, new int[] { 1 }));
    }
}
