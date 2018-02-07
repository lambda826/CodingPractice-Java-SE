/**
 *  @author  Yunxiang He
 *  @date    Dec 14, 2017 7:31:49 PM
 */

package leetcode;

/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

public class _0122_Best_Time_to_Buy_and_Sell_Stock_II {
    /**
     * Solution:
     *
     * --------------------------------------------------------------
     * Steps:
     *
     * --------------------------------------------------------------
     * Notes:
     *
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
