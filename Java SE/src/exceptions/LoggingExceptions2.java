/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 3:40:06 PM
 */

package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/*

it’s more common that you will be catching and loggingsomeone else’s exception, 
so you must generate the log message in the exception handler

 */

public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
