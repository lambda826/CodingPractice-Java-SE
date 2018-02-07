/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Oct 5, 2017 4:13:58 AM
 */

/*

https://www.youtube.com/watch?v=GMzVeWpyTN0
Given a chain <A1, A2, ..., An> of n matrices, where for i = 1, 2, ..., n, 
matrix Ai has dimension pi-1 x pi, 
fully parenthesize the product A1A2...An in a way that minimizes the number of scalar multiplications.

*/

package basicAlgorithms.dynamic_programming;

import utils.Print_Aarray;

/**
 * @author Yunxiang He
 * @date Oct 5, 2017 4:13:58 AM
 */
public class Matrix_Chain_Multiplication {

    public static void matrix_chain_order(int[] p, int[][] m, int[][] s, int n) {
        // length of matrix chain, from 2 to n
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void memorized_matrix_chain(int[] p, int[][] m, int[][] s, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        look_up_table(p, m, s, 0, n - 1);
    }

    private static int look_up_table(int[] p, int[][] m, int[][] s, int i, int j) {
        if (m[i][j] < Integer.MAX_VALUE) {
            return m[i][j];
        }
        if (i == j) {
            m[i][j] = 0;
        } else {
            for (int k = i; k < j; k++) {
                int q = look_up_table(p, m, s, i, k) + look_up_table(p, m, s, k + 1, j) + p[i] * p[k + 1] * p[j + 1];
                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
        return m[i][j];
    }

    private static void print(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] p = new int[] { 30, 35, 15, 5, 10, 20, 25 };
        // n : number of matrices
        int n = p.length - 1;
        // store optimal value
        int[][] m = new int[n][n];
        // store optimal solution
        int[][] s = new int[n][n];
        // matrix_chain_order(p, m, s, n);
        memorized_matrix_chain(p, m, s, n);
        // print value
        Print_Aarray.print_array_2(m);
        System.out.println("----------------------------");
        // print solution
        Print_Aarray.print_array_2(s);
        // print
        print(s, 0, n - 1);
    }

}
