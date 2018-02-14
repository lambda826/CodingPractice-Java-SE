/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 7:14:31 PM
 */

package exceptions;

/*

When an exception is thrown, the exception-handling system looks through the "nearest" handlers in the order they are written. 
When it finds a match, the exception is considered handled, and no further searching occurs.

Matching an exception doesn’t require a perfect match between the exception and its handler. 
A derived-class object will match a handler for the base class, 

If you try to "mask" the derived-class exceptions by putting the base-class catch clause first
the compiler will give you an error message
*/

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {
    public static void main(String[] args) {
        // Catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
        //Catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}