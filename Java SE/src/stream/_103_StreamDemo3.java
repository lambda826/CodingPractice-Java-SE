/**
 *  @author: Yunxiang He
 *  @date  : 2018-03-13 11:48
 */

package stream;

import java.util.ArrayList;

public class _103_StreamDemo3 {

    public static void main(String[] args) {

        // This is now a list of double values. 
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(4.0);
        myList.add(9.0);
        myList.add(16.0);
        myList.add(25.0);

        double productOfSqrRoots = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("Product of square roots: " + productOfSqrRoots);

        double productOfSqrRoots3 = myList.stream().reduce(1.0, (a, b) -> a * Math.sqrt(b));
        System.out.println("Product of square roots: " + productOfSqrRoots3);

        double productOfSqrRoots2 = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b));
        System.out.println("Product of square roots: " + productOfSqrRoots2);

    }
}