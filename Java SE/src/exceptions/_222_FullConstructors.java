/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 12:44:11 PM
 */

package exceptions;

public class _222_FullConstructors {

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }

}

class MyException extends Exception {

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}