/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:59:27 PM
 */

package generics;

class _121_Gen<T extends Number> {
    T ob;

    T vals[]; // OK 

    _121_Gen(T o, T[] nums) {
        ob = o;

        // This statement is illegal. 
        // vals = new T[10]; // can't create an array of T 

        // But, this statement is OK. 
        vals = nums; // OK to assign reference to existent array 
    }
}

public class _221_GenArrays {
    public static void main(String args[]) {
        Integer n[] = { 1, 2, 3, 4, 5 };

        _121_Gen<Integer> iOb = new _121_Gen<Integer>(50, n);

        // Can't create an array of type-specific generic references. 
        //         _121_Gen<Integer> gens[] = new _121_Gen<Integer>[10]; // Wrong! 

        // This is OK
        // You can create an array of references to a generic type if you use a wildcard
        _121_Gen<?> gens[] = new _121_Gen<?>[10]; // OK
    }
}