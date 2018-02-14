/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 6:58:09 PM
 */

package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
If the FileReader constructor is unsuccessful, it throws a FileNotFoundException. This
is the one case in which you don’t want to close the file, because it wasn’t successfully
opened. Any other catch clauses must close the file because it was opened by the time those
catch clauses are entered. (Of course, this gets trickier if more than one method can throw a
FileNotFoundException. In that case, you’ll usually have to break things into several try
blocks.) The close( ) method might throw an exception so it is tried and caught even though
it’s within the block of another catch clause—it’s just another pair of curly braces to the Java
compiler. After performing local operations, the exception is rethrown, which is appropriate
because this constructor failed, and you don’t want the calling method to assume that the
object has been properly created and is valid.

In this example, the finally clause is definitely not the place to close( ) the file, since that
would close it every time the constructor completed. We want the file to be open for the
useful lifetime of the InputFile objec

The getLine( ) method returns a String containing the next line in the file. It calls
readLine( ), which can throw an exception, but that exception is caught so that getLine( )
doesn’t throw any exceptions. One of the design issues with exceptions is whether to handle
an exception completely at this level, to handle it partially and pass the same exception (or a
different one) on, or whether to simply pass it on. Passing it on, when appropriate, can
certainly simplify coding. In this situation, the getLine( ) method converts the exception to
a RuntimeException to indicate a programming error.

The dispose( ) method must be called by the user when the InputFile object is no longer
needed. This will release the system resources (such as file handles) that are used by the
BufferedReader and/or FileReader objects. You don’t want to do this until you’re
finished with the InputFile object. You might think of putting such functionality into a
finalize( ) method, but as mentioned in the Initialization & Cleanup chapter, you can’t
always be sure that finalize( ) will be called (even if you can be sure that it will be called,
you don’t know when). This is one of the downsides to Java: All cleanupother than memory
cleanup—doesn’t happen automatically, so you must inform the client programmers that
they are responsible.

 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            // Wasn’t open, so don’t close it
            throw e;
        } catch (Exception e) {
            // All other exceptions must close it
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        } finally {
            // Don’t close it here!!!
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
}