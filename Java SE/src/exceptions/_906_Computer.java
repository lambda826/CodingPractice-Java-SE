/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:05:06 AM
 */

package exceptions;

/*



 */

public class _906_Computer {
    public void compute() throws Exception {
        throw new RuntimeException("Error processing request");
    }

    // Won't compile 
    // The code does not compile due to the call to compute() in the main() method. 
    // Even though the compute() method only throws an unchecked exception, its method declaration includes the Exception class, which is a checked exception. 
    // For this reason, the checked exception must be handled or declared in the main() method in which it is called. 
    // While there is a try-catch block in the main() method, it is only for the unchecked NullPointerException. 
    // Since Exception is not a subclass of NullPointerException, the checked Exception is not properly handled or declared and the code does not compile,

    //    public static void main(String[] bits) {

    public static void main(String[] bits) throws Exception {
        try {
            new _906_Computer().compute();
            System.out.print("Ping");
        } catch (NullPointerException e) {
            System.out.print("Pong");
            throw e;
        }
    }
}
