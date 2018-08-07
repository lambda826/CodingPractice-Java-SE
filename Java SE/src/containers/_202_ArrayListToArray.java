/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-16 04:20
 */

package containers;

import java.util.ArrayList;

public class _202_ArrayListToArray {

    public static void main(String args[]) {
        // Create an array list. 
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Add elements to the array list. 
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        System.out.println("Contents of al: " + al);

        // Get the array. 
        Integer ia[] = new Integer[al.size()];
        ia = al.toArray(ia);

        int sum = 0;

        // Sum the array. 
        for (int i : ia) {
            sum += i;
        }

        System.out.println("Sum is: " + sum);
    }
}
