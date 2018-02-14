/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:48:03 PM
 */

package exceptions;

public class _115_MultiCatch {
    public static void main(String args[]) {
        int a = 10, b = 0;
        int vals[] = { 1, 2, 3 };

        try {
            int result = a / b; // generate an ArithmeticException  

            //          vals[10] = 19; // generate an ArrayIndexOutOfBoundsException

            // This catch clause catches both exceptions.
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }

        System.out.println("After multi-catch.");
    }
}
