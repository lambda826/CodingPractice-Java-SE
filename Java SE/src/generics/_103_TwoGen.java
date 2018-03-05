/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 11:07:47 AM
 */

package generics;

public class _103_TwoGen<T, V> {
    T ob1;
    V ob2;

    public _103_TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    public void showTypes() {
        System.out.println("Type of T is " + ob1.getClass().getName());
        System.out.println("Type of V is " + ob2.getClass().getName());
    }

    public T getob1() {
        return ob1;
    }

    public V getob2() {
        return ob2;
    }
}

class SimpGen {
    public static void main(String args[]) {

        _103_TwoGen<Integer, String> tgObj = new _103_TwoGen<Integer, String>(88, "Generics");

        // Show the types. 
        tgObj.showTypes();

        // Obtain and show values. 
        int v = tgObj.getob1();
        System.out.println("value: " + v);

        String str = tgObj.getob2();
        System.out.println("value: " + str);
    }
}