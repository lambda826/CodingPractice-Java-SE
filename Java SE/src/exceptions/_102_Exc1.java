/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:49:01 PM
 */

package exceptions;

public class _102_Exc1 {
    static void subroutine() {
        int d = 0;
        int a = 10 / d;
    }

    public static void main(String args[]) {
        _102_Exc1.subroutine();
    }
}