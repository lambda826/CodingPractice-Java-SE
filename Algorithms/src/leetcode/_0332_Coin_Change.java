/**
 * @author Yunxiang He
 */

package leetcode;

import java.util.Arrays;

/*

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

 */

public class _0332_Coin_Change {

    // fast
    static int min = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    public static void coinChange(int[] coins, int amount, int index, int num) {
        if (amount % coins[index] == 0) {
            int newCount = num + amount / coins[index];
            if (newCount < min)
                min = newCount;
        }

        if (index == 0)
            return;

        int possible = amount / coins[index];
        for (int i = possible; i >= 0; i--) {
            int newAmount = amount - coins[index] * i;
            int newNum = num + i;

            int nextCoin = coins[index - 1];
            if (newNum + (newAmount + nextCoin - 1) / nextCoin >= min)
                break;

            coinChange(coins, newAmount, index - 1, newNum);

        }
    }

    // T(n) = O(coins.length * amount)
    // no solution : return -1
    public static int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] table = new int[amount + 1];
        for (int i = 1; i < table.length; i++) {
            int min = Integer.MAX_VALUE;
            int x = coins.length;
            while (x-- > 0) {
                int coin = coins[x];
                if (i - coin >= 0) {
                    min = Math.min(table[i - coin] != Integer.MAX_VALUE ? 1 + table[i - coin] : min, min);
                }
            }
            table[i] = min;
        }
        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
    }

    // T(n) = O(coins.length * amount)
    public static int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] table = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < table[0].length; i++) {
            table[0][i] = -1;
        }
        for (int c = 1; c < coins.length + 1; c++) {
            for (int i = 1; i < table[0].length; i++) {
                int up = table[c - 1][i];
                int left = -1;
                if (i - coins[c - 1] >= 0) {
                    left = table[c][i - coins[c - 1]] == -1 ? -1 : 1 + table[c][i - coins[c - 1]];
                } else
                    left = up;
                table[c][i] = Math.min(left == -1 ? up : left, up == -1 ? left : up);
            }
        }
        return table[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 20, 25 };
        int amount = 115;
        System.out.println(coinChange2(coins, amount));
    }
}
