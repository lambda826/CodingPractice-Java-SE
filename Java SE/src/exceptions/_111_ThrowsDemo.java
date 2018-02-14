/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:18:47 PM
 */

package exceptions;

public class _111_ThrowsDemo {

    // This program contains an error and will not compile.
    //    static void throwOne() {

    static void throwOne() throws IllegalAccessException {
        System.out.println("Inside throwOne.");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
    }
}