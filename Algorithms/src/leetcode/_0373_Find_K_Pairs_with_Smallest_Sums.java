/**
 *  @author  Yunxiang He
 *  @date    Dec 30, 2017 11:08:45 AM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
Return: [1,2],[1,4],[1,6]
The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
Return: [1,1],[1,1]
The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 
Return: [1,3],[2,3]
All possible pairs are returned from the sequence:
[1,3],[2,3]

Credits:
Special thanks to @elmirap and @StefanPochmann for adding this problem and creating all test cases.

 */

public class _0373_Find_K_Pairs_with_Smallest_Sums {

    /**
     * Optimal solution:
     * Min-heap (Priority Queue)
     * --------------------------------------------------------------
     * Steps:
     * Maintain every next index of the element from the other array of every element in one array by a min-heap whose key is the sum
     * Everytime poll one pair and push the other pair
     * --------------------------------------------------------------
     * Tips:
     * Corner case: nums1 and/or nums2 is null
     * Lambda expression runs much slower than directly implementing the functional interface method
     * --------------------------------------------------------------
     *  Time complexity : O(k log k)
     * Space complexity : O(n)
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (k == 0 || nums1.length == 0 || nums2.length == 0)
            return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
            }
        });
        // Too slow
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);

        for (int i = 0; i < nums1.length; i++) {
            pq.add(new int[] { i, 0 });
        }

        while (k > 0) {
            if (pq.size() == 0)
                break;
            int[] temp = pq.poll();
            res.add(new int[] { nums1[temp[0]], nums2[temp[1]] });
            k--;
            if (temp[1] < nums2.length - 1) {
                pq.add(new int[] { temp[0], temp[1] + 1 });
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new _0373_Find_K_Pairs_with_Smallest_Sums().kSmallestPairs(new int[] { -10, -4 }, new int[] { 3, 5 }, 10);
    }
}
