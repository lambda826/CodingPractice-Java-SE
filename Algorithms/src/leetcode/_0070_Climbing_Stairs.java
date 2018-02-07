/**
 *  @author  Yunxiang He
 *  @date    Oct 12, 2017 5:02:08 AM
 */

package leetcode;

/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 */

public class _0070_Climbing_Stairs {

    /**
     * Solution:
     * DP without memorization
     * --------------------------------------------------------------
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int n1 = 1;
        int n2 = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }

    /**
     * Solution 2:
     * Dp
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(n)
     */
    public int solution2(int n) {
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 2] + res[i - 1];
            // Should not plus 2, the problem asks how many distanct ways, not steps
            // res[i] = res[i - 2] + res[i - 1] + 2;
        }
        return res[n - 1];
    }
}
