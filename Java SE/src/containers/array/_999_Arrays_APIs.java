/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-13
 */

package containers.array;

import java.util.Arrays;

public class _999_Arrays_APIs {

    public static void main(String[] args) {

        // static int[] copyOf(int[] original, int newLength), 超出长度的部分自动initialize
        System.out.println("-----------  static int[] copyOf(int[] original, int newLength)");
        int[] original = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] copy = Arrays.copyOf(original, 5);
        System.out.println(Arrays.toString(copy));
        copy = Arrays.copyOf(original, 9);
        System.out.println(Arrays.toString(copy));

        System.out.println();

        // static int[] copyOfRange(int[] original, int from, int to), 超出长度的部分自动initialize, 起点不能未负
        System.out.println("-----------  static int[] copyOfRange(int[] original, int from, int to)");
        copy = Arrays.copyOfRange(original, 1, 9);
        System.out.println(Arrays.toString(copy));
        //        copy = Arrays.copyOfRange(original, -1, 9);

        System.out.println();

        // static void fill(int[] a, int from, int to, int val), toIndex不能超出数组长度
        System.out.println("-----------  static void fill(int[] a, int from, int to, int val)");
        original = new int[5];
        Arrays.fill(original, 1, 3, 3);
        System.out.println(Arrays.toString(original));
    }
}
