/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 2:31:48 AM
 */

package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface _999_InterfaceMethod {

    public void func();

    default void f() {

    }

    static void g() {

    }

    // JDK 9
    //    private void h() {
    //        
    //    }

    //    protected void j() {
    //        
    //    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
    }
}
