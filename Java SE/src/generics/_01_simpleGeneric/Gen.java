/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 10:35:17 AM
 */

package generics._01_simpleGeneric;

public class Gen<T> {
    T ob;

    // Constructor
    public Gen(T o) {
        ob = o;
    }

    public T getob() {
        return ob;
    }

    public void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
