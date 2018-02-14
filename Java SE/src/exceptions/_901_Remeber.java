/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 10:42:56 PM
 */

package exceptions;

public class _901_Remeber {

    public void think() {
        // Every try needs a catch or a finally block
        try {
            throw new Exception();
        } catch (Exception e) {

        }

        try {

        } finally {

        }
    }

    public void think2() throws Exception {
        // If an exception is guranteed to be thrown in try bloak
        // 1. and if there is no catch block, then the method declaration must throw exception and a finally block is needed
        try {
            throw new Exception();
        } finally {

        }
    }

}
