/**
 *  @author: Yunxiang He
 *  @date  : 2018-03-13 12:09
 */

package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class _104_StreamDemo4 {

    public static void main(String[] args) {

        // A list of double values. 
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(4.0);
        myList.add(9.0);
        myList.add(16.0);
        myList.add(25.0);

        // Map the square root of the elements in myList to a new stream. 
        Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));

        // Find the product to the square roots. 
        double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);

        System.out.println("Product of square roots is " + productOfSqrRoots);
    }
}