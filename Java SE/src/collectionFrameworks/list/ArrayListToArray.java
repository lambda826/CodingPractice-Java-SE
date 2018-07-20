/**
 *  @author  Yunxiang He
 *  @date    Feb 6, 2018 2:36:29 AM
 */

package collectionFrameworks.list;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(2);

        System.out.println(al);

        Integer[] ia = new Integer[al.size()];
        ia = al.toArray(ia);

        System.out.println(Arrays.toString(ia));
    }
}
