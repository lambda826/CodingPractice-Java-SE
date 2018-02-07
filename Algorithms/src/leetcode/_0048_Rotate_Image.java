/**
 *  @author  Yunxiang He
 *  @date    Jan 10, 2018 1:24:44 AM
 */

package leetcode;

/*

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 */

public class _0048_Rotate_Image {

    /**
     * Optimal solution:
     * Rotate from the outermost square to the innermost square
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public void rotate(int[][] matrix) {
        int l = matrix.length - 1;
        for (int i = 0; i < (l + 1) / 2; i++) {
            int first = i;
            int last = l - i;
            for (int j = first; j < last; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - j][i];
                matrix[l - j][i] = matrix[l - i][l - j];
                matrix[l - i][l - j] = matrix[j][l - i];
                matrix[j][l - i] = temp;
            }
        }
    }

    /**
     * Optimal solution 2:
     * Rotate diagonally
     * Rotate vertically
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public void solution2(int[][] matrix) {
        // Rotate diagonally
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Rotate vertically
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _0048_Rotate_Image test = new _0048_Rotate_Image();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        test.solution2(matrix);
    }
}
