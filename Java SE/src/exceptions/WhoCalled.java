/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 3:53:30 PM
 */

package exceptions;

/*

The information provided by printStackTrace( ) can also be accessed directly using getStackTrace( ). 
This method returns an array of stack trace elements, each representing one stack frame. Element zero is the top of the stack, and is the last method invocation in the sequence (the point this Throwable was created and thrown). 
The last element of the array and the bottom of the stack is the first method invocation in the sequence.

 */

public class WhoCalled {
    static void f() {
        // Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("--------------------------------");
        g();
        System.out.println("--------------------------------");
        h();
    }
}