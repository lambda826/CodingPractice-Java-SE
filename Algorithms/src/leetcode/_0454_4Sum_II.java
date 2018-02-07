/**
*  @author  Yunxiang He
*  @date    Jan 29, 2018 9:55:28 PM
*/

package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 */

public class _0454_4Sum_II {

    public int fourSumCount_BinarySearch(int[] A, int[] B, int[] C, int[] D) {
        int l = A.length;
        int count = 0;
        int[] sums1 = new int[l * l];
        int[] sums2 = new int[l * l];
        int k = 0;
        return count;
    }

    public int fourSumCount_HashTable(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (map.containsKey(0 - C[i] - D[j])) {
                    count += map.get(0 - C[i] - D[j]);
                }
            }
        }
        return count;
    }
}
