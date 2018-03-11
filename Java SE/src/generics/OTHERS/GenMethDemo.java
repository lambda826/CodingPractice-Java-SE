/**
 *  @author  Yunxiang He
 *  @date    Feb 26, 2018 7:54:47 PM
 */

package generics.OTHERS;

public class GenMethDemo {

    // A class that implements Comparable defines objects that can be ordered. 
    // Thus, requiring an upper bound of Comparable ensures that isIn() can be used only with objects that are capable of being compared.
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++)
            if (x.equals(y[i]))
                return true;
        return false;
    }

    public static void main(String[] args) {
        // Use isIn() on Integers. 
        Integer nums[] = { 1, 2, 3, 4, 5 };
        if (isIn(2, nums))
            System.out.println("2 is in nums");
        if (!isIn(7, nums))
            System.out.println("7 is not in nums");

        System.out.println();

        // Use isIn() on Strings. 
        String strs[] = { "one", "two", "three", "four", "five" };

        if (isIn("two", strs))
            System.out.println("two is in strs");

        if (!isIn("seven", strs))
            System.out.println("seven is not in strs");

        // Opps! Won't compile! Types must be compatible. 
        //        if(isIn("two", nums)) 
        //          System.out.println("two is in strs"); 
    }
}
