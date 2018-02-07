/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 4:00:08 AM
 */

package leetcode;

/*

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

 */

public class _0441_Arranging_Coins {

    /**
     * Solution:
     * Math
     * --------------------------------------------------------------
     *  Time complexity : O(1)
     * Space complexity : O(1)
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(8 * (long) n + 1) - 1) / 2;
    }

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n)
     * Space complexity : O(1)
     */
    public int solution2(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Overflow
            double s = 0.5 * mid * mid + 0.5 * mid;
            if (s == n) {
                return mid;
            } else if (s < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    public static void main(String[] args) {
        _0441_Arranging_Coins test = new _0441_Arranging_Coins();
        int s = 1804289383;
        System.out.println(test.arrangeCoins(s));
        System.out.println(test.solution2(s));
    }
}
