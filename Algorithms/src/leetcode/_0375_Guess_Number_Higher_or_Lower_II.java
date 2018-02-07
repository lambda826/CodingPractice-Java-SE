/**
 *  @author  Yunxiang He
 *  @date    Dec 26, 2017 1:17:57 AM
 */

package leetcode;

/*

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

Credits:
Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.

*/

public class _0375_Guess_Number_Higher_or_Lower_II {

    // Corner case n = 1
    // DP solution
    // Find the local maximum and global minimum to guarantee the win
    // The length of the array is n + 2
    // The index 0 is for k - 1;
    // The index n + 1 is for k + 1;
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] minPrice = new int[n + 2][n + 2];
        for (int i = 1; i < n; i++) {
            for (int s = 1; s + i < n + 1; s++) {
                minPrice[s][s + i] = Integer.MAX_VALUE;
                for (int k = s; k <= i + s; k++) {
                    minPrice[s][s + i] = Math.min(minPrice[s][s + i], k + Math.max(minPrice[k + 1][s + i], minPrice[s][k - 1]));
                }
            }
        }
        return minPrice[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new _0375_Guess_Number_Higher_or_Lower_II().getMoneyAmount(9));
    }
}
