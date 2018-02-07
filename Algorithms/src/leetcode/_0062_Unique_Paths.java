/**
 *  @author  Yunxiang He
 */

package leetcode;

/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 */

public class _0062_Unique_Paths {

    public int uniquePaths_DP_OneD(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
            dp[0] = 0;
        }
        return dp[n];
    }

    public int uniquePaths_DP_TwoD(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        _0062_Unique_Paths test = new _0062_Unique_Paths();
        System.out.println(test.uniquePaths_DP_OneD(2, 1));
    }
}
