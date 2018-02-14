/**
 *  @author  Yunxiang He
 *  @date    Feb 13, 2018 9:27:43 PM
 */

package exceptions;

class MyException3 extends Exception {
    private int detail;

    MyException3(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }
}

class _113_ExceptionDemo {
    static void compute(int a) throws MyException3 {
        System.out.println("Called compute(" + a + ")");
        if (a > 10)
            throw new MyException3(a);
        System.out.println("Normal exit");
    }

    public static void main(String args[]) {
        try {
            compute(1);
            compute(20);
        } catch (MyException3 e) {
            System.out.println("Caught " + e);
        }
    }
}