/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 5:38:55 PM
 */

package generics;

public class _212_Gen2<T> extends _201_Gen<T> {
    public _212_Gen2(T o) {
        super(o);
    }

    @Override
    public T getob() {
        System.out.print("Gen2's getob(): ");
        return ob;
    }
}