package util;

/**
 *  @author  Yunxiang He
 *  @date    Jan 12, 2018 5:06:04 PM
 */

/*



 */

public class ThisConstructor {
    class A {
        private int a;
        private int b;
        private int c;

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public A(int c) {
            this(1, 2);
            this.c = c;
        }
    }
}
