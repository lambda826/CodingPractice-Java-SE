/**
 *  @author  Yunxiang He
 *  @date    Jan 25, 2018 3:29:03 AM
 */

package leetcode;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

 */

public class _0074_Search_a_2D_Matrix {

    public boolean searchMatrix_BinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int lo = 0;
        int hi = row;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (target < matrix[lo][0]) {
            if (0 == lo) {
                return false;
            } else {
                lo--;
            }
        }
        int lo2 = 0;
        int hi2 = col;
        while (lo2 <= hi2) {
            int mid = lo2 + (hi2 - lo2) / 2;
            if (target == matrix[lo][mid]) {
                return true;
            } else if (target > matrix[lo][mid]) {
                lo2 = mid + 1;
            } else {
                hi2 = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix_BinarySearch2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col;
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (lo / col >= row || lo % col >= col) {
            return false;
        }
        return target == matrix[lo / col][lo % col];
    }

    public boolean searchMatrix_Scan(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _0074_Search_a_2D_Matrix test = new _0074_Search_a_2D_Matrix();
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        //        int[][] matrix = { { 3 } };
        int target = 3;
        System.out.println(test.searchMatrix_BinarySearch(matrix, target));
        System.out.println(test.searchMatrix_BinarySearch2(matrix, target));
        System.out.println(test.searchMatrix_Scan(matrix, target));
    }
}
