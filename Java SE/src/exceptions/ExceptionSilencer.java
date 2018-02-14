/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 6:33:50 PM
 */

package exceptions;

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // Using ‘return’ inside the finally block
            // will silence any thrown exception.
            return;
        }
    }
}
