/**
 *  @author  Yunxiang He
 *  @date    Jan 17, 2018 5:58:04 PM
 */

package leetcode;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.

 */

public class _0240_Search_a_2D_Matrix_II {

    /**
     * Solution:
     * Scan the matrix
     * --------------------------------------------------------------
     *  Time complexity : O(n * m)
     * Space complexity : O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length) {
            while (row - 1 >= 0 && matrix[row][col] > target) {
                row--;
            }
            if (matrix[row][col] == target) {
                return true;
            }
            col++;
        }
        return false;
    }

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(log n * log n)
     * Space complexity : O(1)
     */
    public boolean solution2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return searchMatrixAux(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean searchMatrixAux(int[][] matrix, int target, int xLo, int xHi, int yLo, int yHi) {
        if (xLo > xHi || yLo > yHi || xLo >= matrix.length || yLo >= matrix[0].length) {
            return false;
        }
        int xMid = xLo + (xHi - xLo) / 2;
        int yMid = yLo + (yHi - yLo) / 2;
        if (target == matrix[xMid][yMid]) {
            return true;
        } else if (target > matrix[xMid][yMid]) {
            int _xLo = xMid + 1;
            int _yLo = yMid + 1;
            return searchMatrixAux(matrix, target, _xLo, xHi, yLo, yHi) || searchMatrixAux(matrix, target, xLo, xHi, _yLo, yHi);

        } else {
            int _xHi = xMid - 1;
            int _yHi = yMid - 1;
            return searchMatrixAux(matrix, target, xLo, _xHi, yLo, yHi) || searchMatrixAux(matrix, target, xLo, xHi, yLo, _yHi);
        }
    }

    public static void main(String[] args) {
        _0240_Search_a_2D_Matrix_II test = new _0240_Search_a_2D_Matrix_II();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        //        int[][] matrix = { { -5 } };
        int target = 1;
        System.out.println(test.searchMatrix(matrix, target));

    }

}
