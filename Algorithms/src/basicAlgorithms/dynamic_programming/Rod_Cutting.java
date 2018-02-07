/*

The rod-cutting problem is the following. 
Given a rod of length n inches and a table of prices pi for i D 1, 2, ..., n, 
determine the maximum revenue rn obtainable by cutting up the rod and selling the pieces. 
Note that if the price pn for a rod of length n is large enough, an optimal solution may require no cutting at all.

 */

package basicAlgorithms.dynamic_programming;

/**
 * @author Yunxiang He
 * @date Oct 5, 2017 4:13:58 AM
 */
public class Rod_Cutting {

    // Recursive top-down implementation
    // T(n) = O(2 ^ n)
    public static int topDown_CutRod(int n, int[] prize, int[] s) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int result = (prize[i] + topDown_CutRod(n - i, prize, s));
            if (result > max) {
                max = result;
                s[n] = i;
            }
        }
        return max;
    }

    // 2 approaches of dynamic programming :

    ///////////////////////////////////////////////////////////////////////
    // top-down with memorization
    // T(n) = O(n ^ 2)
    public static int memorized_CutRod(int n, int[] prize, int[] r, int[] s) {
        for (int i = 0; i < n + 1; i++) {
            r[i] = -1;
        }
        return memorized_CutRod_Aux(n, prize, r, s);
    }

    private static int memorized_CutRod_Aux(int n, int[] prize, int[] r, int[] s) {
        int max = 0;
        if (r[n] >= 0) {
            return r[n];
        }
        for (int i = 1; i <= n; i++) {
            int result = (prize[i] + memorized_CutRod_Aux(n - i, prize, r, s));
            if (result > max) {
                max = result;
            }
        }
        r[n] = max;
        return max;
    }
    ///////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////
    // bottom-up method
    // T(n) = O(n ^ 2)
    public static int bottomUp_CutRod(int n, int[] prize, int[] r, int[] s) {
        for (int j = 1; j < n + 1; j++) {
            int max = 0;
            for (int i = 1; i <= j; i++) {
                int result = (prize[i] + r[j - i]);
                if (result > max) {
                    max = result;
                    s[j] = i;
                }
                r[j] = max;
            }
        }
        return r[n];
    }
    ///////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        int[] prize = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        int n = 6;
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        System.out.println(topDown_CutRod(n, prize, s));
        System.out.println(memorized_CutRod(n, prize, r, s));
        System.out.println(bottomUp_CutRod(n, prize, r, s));
        print(s, n);
    }

    private static void print(int[] s, int n) {
        while (n > 0) {
            System.out.println(s[n]);
            n = n - s[n];
        }
    }

}
