/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-08
 */

package oop.inheritance;

public class _999_Override {

}

class Sup {

}

class Sub extends Sup {

}

class A {

    Sup get() {
        return null;
    }

}

class B extends A {

    @java.lang.Override
    Sub get() {
        return new Sub();
    }

}