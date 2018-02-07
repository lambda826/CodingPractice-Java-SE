/**
 *  @author  Yunxiang He
 *  @date    Jan 3, 2018 12:18:06 AM
 */

package basicAlgorithms.sort;

import utils.Print_Aarray;

public class QuickSort {

    /**
     * Solution:
     * Divide and conquer
     * --------------------------------------------------------------
     * Steps:
     * Partition array into to subarrays
     * Choose a pivot
     * Each element of the first array is less that or equal to the pivot
     * Each element of the second arry is great than the pivot
     * Sort each subarray recursively 
     * --------------------------------------------------------------
     * Tips:
     * 
     * --------------------------------------------------------------
     *  Worst-case running time : θ(n^2)
     *  Expected running time : θ(n log n)
     * Space complexity : O(1)
     */
    public int[] quickSort(int[] arr) {
        return quickSortAux(arr, 0, arr.length - 1);
    }

    private int[] quickSortAux(int[] arr, int l, int r) {
        int q = partition(arr, l, r);
        if (l < q - 1)
            quickSortAux(arr, l, q - 1);
        if (q + 1 < r)
            quickSortAux(arr, q + 1, r);
        return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 2, 1, 23, 1, 3, 6, 1, 21, 15 };
        Print_Aarray.print_array_1(new QuickSort().quickSort(test));
    }

}
