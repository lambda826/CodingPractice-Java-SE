/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 6:57:13 PM
 */

package generics;

class _120_Wrong<T> {
    // Wrong, no static variables of type T. 
    //    static T ob;

    // Wrong, no static method can use T. 
    //    static T getob() {
    //        return ob;
    //    }
}