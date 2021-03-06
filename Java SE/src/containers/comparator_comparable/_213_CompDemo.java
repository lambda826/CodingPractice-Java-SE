/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-27 17:08
 */

package containers.comparator_comparable;

import java.util.Comparator;
import java.util.TreeSet;

class MyComp implements Comparator<String> {

    public int compare(String aStr, String bStr) {
        // Reverse the comparison. 
        return bStr.compareTo(aStr);
    }
}

public class _213_CompDemo {

    public static void main(String args[]) {
        TreeSet<String> ts = new TreeSet<String>(new MyComp());

        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Display the elements. 
        for (String element : ts) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}