/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 4:15:31 PM
 */

package leetcode;

import java.util.Arrays;

/*

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, 
find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, 
and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.

Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

 */

public class _0475_Heaters {

    /**
     * Solution:
     * Find the nearest heater to every house
     * The maximum distance from the heater to every house is what is needed
     * --------------------------------------------------------------
     *  Time complexity : O(n + m)
     * Space complexity : O(1)
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int minMax = Integer.MIN_VALUE;
        for (int house : houses) {
            while (i < heaters.length - 1 && Math.abs(house - heaters[i]) >= Math.abs(house - heaters[i + 1])) {
                i++;
            }
            minMax = Math.max(minMax, Math.abs(house - heaters[i]));
        }
        return minMax;
    }

    /**
     * Solution 2:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int solution2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        // Range should start from the largest possbile value
        int lo = 0;
        int hi = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isInrange(houses, heaters, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isInrange(int[] houses, int[] heaters, int radius) {
        int i = 0;
        for (int h : heaters) {
            // Watch out for overflow here
            long loRange = h - radius;
            long hiRange = (long) (h + radius);
            while (houses[i] >= loRange && houses[i] <= hiRange) {
                if (i++ >= houses.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _0475_Heaters test = new _0475_Heaters();
        int[] house = { 1, 2, 8, 9 };
        int[] heaters = { 1, 2, 8, 9 };
        System.out.println(test.findRadius(house, heaters));
        System.out.println(test.solution2(house, heaters));
    }
}
