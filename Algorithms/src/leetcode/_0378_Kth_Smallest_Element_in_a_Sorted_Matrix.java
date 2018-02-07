/**
 *  @author  Yunxiang He
 *  @date    Jan 2, 2018 12:45:21 AM
 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n^2.

 */

public class _0378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    /**
     * Optimal solution:
     * Binary search
     * --------------------------------------------------------------
     * Steps:
     * Count the element that is less than or equal to the mid
     * If the this number is less than k, the whole half should be eliminated (including mid)
     * So set low to (mid + 1)
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int lo = matrix[0][0];
        int hi = matrix[n][n];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = n;
            for (int i = 0; i <= n; i++) {
                // Count the elements that are less than or equal to mid
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1;
            }
            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    /**
     * Solution 2:
     * Max-heap
     * --------------------------------------------------------------
     * Steps:
     * Maintain a max-heap of size k
     * When the heap is full, poll an element
     * --------------------------------------------------------------
     * Tips:
     * The kth smallest element has an index of i <= (i + 1) * (j + 1)
     * --------------------------------------------------------------
     *  Time complexity : O(k log^2 n)
     * Space complexity : O(k)
     */
    public int solution2(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });

        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + 1) * (j + 1) > k)
                    break;
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { new int[] { 1, 5, 9, 11 }, new int[] { 2, 6, 10, 12 }, new int[] { 7, 8, 11, 13 }, new int[] { 9, 10, 12, 15 } };
        int k = 6;
        _0378_Kth_Smallest_Element_in_a_Sorted_Matrix test = new _0378_Kth_Smallest_Element_in_a_Sorted_Matrix();
        System.out.println(test.kthSmallest(matrix, k));
        System.out.println(test.solution2(matrix, k));
    }
}
