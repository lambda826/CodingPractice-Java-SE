/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 11:09:31 PM
 */

package exceptions;

public interface _902_Printer {
    void print1() throws PrintException;

    void print2() throws PrintException;

    void print3() throws PrintException;

    void print4() throws PrintException;
}

class PaperPrinter implements _902_Printer {

    public void print1() throws PrintException {

    }

    public void print2() throws BadPrintException {

    }

    public void print3() {

    }
    // not allowed
    // overriden methods or implementation methods cannot have the method declaration that throws the exception higher than the original method declaration
    //    public void print4() throws Exception {
    //
    //    }

    public void print4() {

    }
}

class PrintException extends Exception {
}

class BadPrintException extends PrintException {
}
