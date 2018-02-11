package others;
/**
 *  @author  Yunxiang He
 *  @date    Jan 12, 2018 11:40:29 AM
 */


/*



 */

public class InnerClassDemo {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
        outer.test2();
    }
}

class Outer {
    int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    void test2() {
        for (int i = 0; i < 10; i++) {
            @SuppressWarnings("hiding")
            class Inner {
                void display() {
                    System.out.println(outer_x);
                }
            }
            Inner inner = new Inner();
            inner.display();
        }
    }

    class Inner {
        void display() {
            System.out.println(outer_x + 1);
        }
    }

}
