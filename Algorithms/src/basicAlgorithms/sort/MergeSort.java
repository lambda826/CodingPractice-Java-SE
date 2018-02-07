/**
 * @author Yunxiang He
 * @date Oct 9, 2017 5:25:36 PM
 */

package basicAlgorithms.sort;

import java.util.Arrays;

import utils.Print_Aarray;

public class MergeSort {

    public static void mergeSort(int[] arr, int from, int to) {
        if (from < to) {
            int mid = (from + to) / 2;
            mergeSort(arr, from, mid);
            mergeSort(arr, mid + 1, to);
            mergeAux(arr, from, mid + 1, to);
        }
    }

    public static void mergeAux(int[] arr, int from, int mid, int to) {
        int[] left = Arrays.copyOfRange(arr, from, mid);
        int[] right = Arrays.copyOfRange(arr, mid, to + 1);
        int l = 0;
        int r = 0;
        for (int i = from; i <= to; i++) {
            if ((l < left.length && r < right.length && left[l] > right[r]) || l == left.length) {
                arr[i] = right[r];
                r++;
            } else if (l < left.length && r < right.length && left[l] < right[r] || r == right.length) {
                arr[i] = left[l];
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 12, 33, 42, 15, 16, 1, 2, 4 };
        mergeSort(arr, 0, arr.length - 1);
        Print_Aarray.print_array_1(arr);
    }
}
