/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:45:07 PM
 */

package exceptions;

/*



 */

public class _114_ChainExcDemo {
    static void demoproc() {
        // create an exception
        NullPointerException e = new NullPointerException("top layer");

        // add a cause
        e.initCause(new ArithmeticException("cause"));

        throw e;
    }

    public static void main(String args[]) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            // display top level exception
            System.out.println("Caught: " + e);

            // display cause exception
            System.out.println("Original cause: " + e.getCause());
        }
    }
}