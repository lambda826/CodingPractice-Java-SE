/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 7:01:17 PM
 */

package exceptions;

/*

The construction of the InputFile object is effectively in its
own try block. If that construction fails, the outer catch clause is entered and dispose( ) is
not called. However, if construction succeeds then you want to make sure the object is
cleaned up, so immediately after construction you create a new try block. The finally that
performs cleanup is associated with the inner try block; this way, the finally clause is not
executed if construction fails, and it is always executed if construction succeeds.

 */

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ; // Perform line-by-line processing here...
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
