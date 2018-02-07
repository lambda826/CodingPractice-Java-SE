/**
 *  @author  Yunxiang He
 *  @date    Jan 2, 2018 1:31:12 PM
 */

package leetcode;

import java.util.PriorityQueue;

/*

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

 */

public class _0215_Kth_Largest_Element_in_an_Array {

    /**
     * Solution:
     * QuickSort
     * --------------------------------------------------------------
     * Steps:
     * Find the position of the pivot
     * Compare the pivot with k
     * --------------------------------------------------------------
     * Tips:
     * Be careful of the boundary
     * --------------------------------------------------------------
     *  Time complexity : avg: O(n)
     * Space complexity : O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int p = nums[0];
        k = nums.length - k;
        while (true) {
            int left = i + 1;
            int right = j;
            while (left <= right) {
                while (left <= right && nums[left] <= p) {
                    left++;
                }
                while (nums[right] > p) {
                    right--;
                }
                if (left < right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
            swap(nums, --left, i);
            if (left == k) {
                break;
            } else if (left < k) {
                i = left + 1;
                p = nums[i];
            } else {
                j = left - 1;
                p = nums[i];
            }
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Solution 2:
     * Similar with optimal solution
     * The only difference is to choose the pivot of mid index
     */
    public int solution2(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int p = nums[start + (end - start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] < p) {
                i++;
            }
            while (i <= j && nums[j] > p) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSelect(nums, start, j, k);
        } else if (k >= i) {
            return quickSelect(nums, i, end, k);
        }
        return nums[k];
    }

    /**
     * Solution:
     * MinHeap
     * --------------------------------------------------------------
     * Steps:
     * Maintain a minheap of maximum size k + 1;
     * When the size is larger than k, poll an element
     * --------------------------------------------------------------
     *  Time complexity : O(k log n)
     * Space complexity : O(k)
     */
    public int solution3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 5, 2, 4, 1, 3, 6, 0 }, 3));
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 7, 6, 5, 4, 3, 2, 1 }, 6));
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 2, 8, 7, 1, 3, 5, 6, 4 }, 5));
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 1, 2, 3, 4 }, 1));
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 99, 99 }, 1));
        System.out.println(new _0215_Kth_Largest_Element_in_an_Array().solution3(new int[] { 2, 1 }, 1));
    }
}
