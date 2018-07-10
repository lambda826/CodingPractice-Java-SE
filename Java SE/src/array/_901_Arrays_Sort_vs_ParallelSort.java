/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-01 23:17
 */

package array;

import java.util.Arrays;
import java.util.Random;

public class _901_Arrays_Sort_vs_ParallelSort {

    static int[] length = { 10, 1000, 100000, 200000, 1000000, 10000000, 100000000 };

    static int[] generateArray(int length) {
        int[] nums = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextInt(length);
        }
        return nums;
    }

    static void compareSorts(int[] nums) {
        int[] nums1 = nums.clone();
        int[] nums2 = nums.clone();
        System.out.println("--------------------------------------------------");
        // Sort
        long a = System.currentTimeMillis();
        Arrays.sort(nums1);
        System.out.println("        Sort: " + "Length : " + nums.length + " " + " Duration : " + (System.currentTimeMillis() - a));
        // ParallelSort
        a = System.currentTimeMillis();
        Arrays.parallelSort(nums2);
        System.out.println("ParallelSort: " + "Length : " + nums.length + " " + " Duration : " + (System.currentTimeMillis() - a));
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        for (int len : length) {
            compareSorts(generateArray(len));
        }
    }
}
