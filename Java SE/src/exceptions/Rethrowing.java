/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 3:56:14 PM
 */

package exceptions;

import utils.Print;

/*

Rethrowing an exception causes it to go to the exception handlers in the nexthigher context.
Any further catch clauses for the same try block are still ignored. 

In addition, everything about the exception object is preserved, so the handler at the higher context that catches the specific exception type can extract all the information from that object.
If you simply rethrow the current exception, the information that you print about that exception in printStackTrace() will pertain to the exception’s origin, not the place where you rethrow it. 
If you want to install new stack trace information, you can do so by calling fillInStackTrace(), which returns a Throwable object that it creates by stuffing the current stack information into the old exception object.

 */

public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        System.out.println();
        Print.print("-----------------------------------------------------------------");
        System.out.println();
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}