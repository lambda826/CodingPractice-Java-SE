/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 10:35:17 AM
 */

package generics;

public class _201_Gen<T> {
    T ob;

    // Constructor
    public _201_Gen(T o) {
        ob = o;
    }

    public T getob() {
        return ob;
    }

    public void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
