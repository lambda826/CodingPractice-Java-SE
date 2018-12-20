/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-09
 */

package interfaces;

interface Interface {

    void A();

    void B();
}

public class _998_Implementation implements Interface {

    @Override
    public void A() {
    }

    @Override
    public void B() {
    }

    // The overriden methods from implementation must be defined as public
    // Otherwise, you’d be reducing the accessibility of a method during inheritance, which is not allowed by the Java compiler
    //    @Override
    //     void B() {
    //    }
}

abstract class AAA {

    abstract public void methodA();

    private static void method() {
    }

}