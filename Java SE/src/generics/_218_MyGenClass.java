/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:53:05 PM
 */

package generics;

/*



 */

public class _218_MyGenClass<T, V> {

    T ob1;
    V ob2;

    // These two overloaded methods are ambiguous and will not compile. 
    //    void set(T o) {
    //        ob1 = o;
    //    }
    //
    //    void set(V o) {
    //        ob2 = o;
    //    }
}
