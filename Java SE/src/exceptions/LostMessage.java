/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 6:26:17 PM
 */

package exceptions;

/*

Unfortunately, there’s a flaw in Java’s exception implementation. Although exceptions are an indication of a crisis in your program and should never be ignored, it’s possible for an exception to simply be lost.
This happens with a particular configuration using a finally

You can see from the output that there’s no evidence of the VerylmportantException, which is simply replaced by the HoHumException in the finally clause. 
This is a rather serious pitfall, since it means that an exception can be completely lost, and in a far more subtle and difficult-to-detect fashion than the preceding example. 
In contrast, C++ treats the situation in which a second exception is thrown before the first one is handled as a dire programming error. 
Perhaps a future version of Java will repair this problem (on the other hand, you will typically wrap any method that throws an exception, such as dispose() in the example above, inside a try-catch clause).

 */

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}