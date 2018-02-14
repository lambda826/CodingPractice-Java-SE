/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 3:32:54 PM
 */

package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/*

The static Logger.getLogger() method creates a Logger object associated with the String argument (usually the name of the package and class that the errors are about) which sends its output to System.err. 
The easiest way to write to a Logger is just to call the method associated with the level of logging message; here, severe() is used. 
To produce the String for the logging message, we’d like to have the stack trace where the exception is thrown, but printStackTrace() doesn’t produce a String by default. 
To get a String, we need to use the overloaded printStackTrace() that takes a java.io.PrintWriter object as an argument (all of this will be fully explained in the I/O chapter). 
If we hand the Print Writer constructor a java.io.StringWriter object, the output can be extracted as a String by calling toString().

 */

class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}