/**
 *  @author  Yunxiang He
 *  @date    Feb 4, 2018 12:57:58 AM
 */

package ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

    public static void main(String[] args) {
        //        int[][] game = new int[2][2];
        //        Object[] obj = game;
        //        obj[0] = new int[] { 1, 1 };
        //        System.out.println(game[0][0]);
        //
        //        System.out.println(Arrays.toString(args));
        //
        //        String[] os = { "Mac", "Windows", "Linux", };
        //        System.out.println(Arrays.binarySearch(os, "Linux"));
        //
        //        int[] nums = { 1, 2, 4, 5, };
        //        System.out.println(Arrays.binarySearch(nums, 3));
        //
        //        int arr[] = new int[] { 1, 3, 4, 5, 8, 9 };
        //        Arrays.sort(arr);
        //        int index1 = Arrays.binarySearch(arr, 6);
        //        int index2 = Arrays.binarySearch(arr, 4);
        //        int index3 = Arrays.binarySearch(arr, 0);
        //        int index4 = Arrays.binarySearch(arr, 10);
        //        System.out.println("index1 = " + index1 + ", index2 = " + index2 + ", index3 = " + index3 + ", index4 = " + index4);
        //
        //        String[][] list = { { "book" }, { "book", "game" } };
        //        System.out.println(list.length);
        //        System.out.println(list[0].length);
        //        System.out.println(list[1].length);
        ////        System.out.println(args[0]);
        //        //        String iString = 1;
        //
        //        out:for (int i = 0, j = 0; i < 5; i++) {
        //
        //        }
        //
        //        call("a");
        //        
        //        Integer[] integers = new Integer[10];

        ArrayList<Integer>[] lists = new ArrayList[10];
        ArrayList<Integer>[] lists2 = new ArrayList[] { new ArrayList<>(), new ArrayList<>() };
        System.out.println(Arrays.deepToString(lists));
        System.out.println(Arrays.deepToString(lists2));

        List<Integer>[] spheres = (List<Integer>[]) new List[10];

        System.out.println(Arrays.deepToString(spheres));
    }

    public static void call(String... a) {

    }
}
