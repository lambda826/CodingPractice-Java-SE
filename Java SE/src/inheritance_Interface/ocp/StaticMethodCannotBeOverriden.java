/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 3:19:42 AM
 */

package inheritance_Interface.ocp;

public class StaticMethodCannotBeOverriden extends SuperClazz {
//    public void print() {
//        System.out.println("cannot override");
//    }
}

class SuperClazz {
    public static void print() {
    }
}