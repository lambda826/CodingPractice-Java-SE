/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:51:20 PM
 */

package exceptions;

/*

When you use multiple catch statements, it is important to remember that exception subclasses must come before any of their superclasses
If you try to "mask" the derived-class exceptions by putting the  base-class catch clause first the compiler will give you an error message

 */
public class _107_SuperSubCatch {

}

/*  This program contains an error.
 
   A subclass must come before its superclass in 
   a series of catch statements. If not, 
   unreachable code will be created and a
   compile-time error will result.
*/
class SuperSubCatch {
    public static void main(String args[]) {
        try {
            int a = 0;
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Generic Exception catch.");
        }

        /* This catch is never reached because
           ArithmeticException is a subclass of Exception. */
        //        catch (ArithmeticException e) { // ERROR - unreachable
        //            System.out.println("This is never reached.");
        //        }
    }
}
