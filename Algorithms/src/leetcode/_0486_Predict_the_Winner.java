/**
 *  @author  Yunxiang He
 *  @date    Dec 27, 2017 4:46:25 PM
 */

package leetcode;

import java.util.Arrays;

/*

Given an array of scores that are non-negative integers. 
Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. 
Each time a player picks a number, that number will not be available for the next player. 
This continues until all the scores have been chosen. 
The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. 
You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: 
Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. 
If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.

Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: 
Player 1 first chooses 1. 
Then player 2 have to choose between 5 and 7. 
No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), 
so you need to return True representing player1 can win.

Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.

*/

public class _0486_Predict_the_Winner {

    // Solution 1: DP
    // dp[i][j] records how much higher of the score of first-move players than the other player
    // So the diagonal dp[i][i] (when i = j) saves the score that the first-move player (cause the other player cannot move anymore)
    // What we need is dp[0][n];
    // Space complexity: O(nn)

    // If the length of the array is even, then the first player will always win
    // e.g. there are an array of 6 elements
    // E1, O1, E2, O2, E3, O3
    // Sum_E = E1 + E2 + E3
    // Sum_O = O1 + O2 + O3
    // Sum_E >= Sum_O or Sum_E <= Sum_O
    // The first can always choose to pick the bigger one

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;

        if ((n & 1) == 0) {
            return true;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    // Improve the space complexity
    // Because we only need the half of the table
    // And every element relies on the element which is left and down to it
    // Space complexity: O(n)
    public boolean PredictTheWinnerImproved(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int k = n - 2; k >= 0; k--) {
            for (int j = n - 1, i = k; i >= 0; j--, i--) {
                System.out.println("i : " + i + "  j : " + j);
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }

    // Solution 2: minimax
    public boolean PredictTheWinner1(int[] nums) {
        return max(nums, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, nums.length - 1, 0) < 0 ? false : true;
    }

    private int max(int[] nums, int alfa, int beta, int left, int right, int utility) {
        if (left > right) {
            if (utility >= 0) {
                return 1;
            } else {
                return -1;
            }
        }
        int v = Integer.MIN_VALUE;
        v = Math.max(Math.max(v, min(nums, alfa, beta, left + 1, right, utility + nums[left])), min(nums, alfa, beta, left, right - 1, utility + nums[right]));
        if (v > beta) {
            return v;
        }
        alfa = Math.max(alfa, v);
        return v;
    }

    private int min(int[] nums, int alfa, int beta, int left, int right, int utility) {
        if (left > right) {
            if (utility >= 0) {
                return 1;
            } else {
                return -1;
            }
        }
        int v = Integer.MAX_VALUE;
        v = Math.min(Math.min(v, max(nums, alfa, beta, left + 1, right, utility - nums[left])), max(nums, alfa, beta, left, right - 1, utility - nums[right]));
        if (v < alfa) {
            return v;
        }
        beta = Math.min(beta, v);
        return v;
    }

    public static void main(String[] args) {
        System.out.println(new _0486_Predict_the_Winner().PredictTheWinnerImproved(new int[] { 2, 4, 55, 6, 8 }));
    }
}
