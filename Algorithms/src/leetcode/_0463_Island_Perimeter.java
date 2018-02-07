/**
 *  @author  Yunxiang He
 *  @date    Jan 9, 2018 7:28:15 PM
 */

package leetcode;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16

*/

public class _0463_Island_Perimeter {
    /**
     * --------------------------------------------------------------
     *  Time complexity : O(n * m)
     * Space complexity : O(1)
     */
    public static int islandPerimeter(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int islands = 0;
        int rightNeighbors = 0;
        int downNeighbors = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        rightNeighbors++;
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        downNeighbors++;
                    }
                }
            }
        }
        return islands * 4 - (rightNeighbors + downNeighbors) * 2;
    }

    public static void main(String[] args) {
        int[][] grid1 = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        int[][] grid2 = { { 1, 1 } };
        int[][] grid3 = { { 1, 1 }, { 1, 1 } };
        int[][] grid4 = { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 1 } };
        System.out.println(islandPerimeter(grid1));
        System.out.println(islandPerimeter(grid2));
        System.out.println(islandPerimeter(grid3));
        System.out.println(islandPerimeter(grid4));
    }

}
