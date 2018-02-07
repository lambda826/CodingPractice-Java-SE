/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Oct 6, 2017 6:59:26 AM
 */

/*

In the longest-common-subsequence problem, we are given two sequences X = <x1, x2, ..., xm> and Y = <y1, y2, ..., yn> 
and wish to find a maximum length common subsequence of X and Y

*/
package basicAlgorithms.dynamic_programming;

import utils.Print_Aarray;

/**
 * @author Yunxiang He
 * @date Oct 6, 2017 6:59:26 AM
 */
public class Longest_Cmmon_Subsequence {

    public static void lcs_length(String[] sequenceA, String[] sequenceB, int m, int n, String[][] b, int[][] c) {

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (sequenceA[i - 1] == sequenceB[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i - 1][j - 1] = "�I";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i - 1][j - 1] = "��";

                } else {
                    c[i][j] = c[i][j - 1];
                    b[i - 1][j - 1] = "��";
                }

            }
        }
        Print_Aarray.print_array_2(c);
        print_LCS(b, sequenceA, m - 2, n - 2);
    }

    private static void print_LCS(String[][] b, String[] sequenceA, int i, int j) {
        if (i == -1 || j == -1) {
            return;
        }
        if (b[i][j] == "�I") {
            print_LCS(b, sequenceA, i - 1, j - 1);
            System.out.print(sequenceA[i]);
        } else if (b[i][j] == "��") {
            print_LCS(b, sequenceA, i - 1, j);
        } else {
            print_LCS(b, sequenceA, i, j - 1);
        }
    }

    public static void main(String[] args) {
        String[] sequenceA = new String[] { "A", "B", "C", "B", "D", "A", "B" };
        String[] sequenceB = new String[] { "B", "D", "C", "A", "B", "A" };
        int m = sequenceA.length;
        int n = sequenceB.length;
        // optimal solution
        String[][] b = new String[m][n];
        // max lengty
        int[][] c = new int[m + 1][n + 1];
        lcs_length(sequenceA, sequenceB, m + 1, n + 1, b, c);
    }

}
