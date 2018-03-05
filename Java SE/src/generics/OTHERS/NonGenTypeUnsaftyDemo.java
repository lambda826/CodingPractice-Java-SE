/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 11:05:18 AM
 */

package generics.OTHERS;

//NonGen is functionally equivalent to Gen but does not use generics
class NonGen {
    Object ob;

    NonGen(Object o) {
        ob = o;
    }

    Object getob() {
        return ob;
    }

    void showType() {
        System.out.println("Type of ob is " + ob.getClass().getName());
    }
}

public class NonGenTypeUnsaftyDemo {
    public static void main(String args[]) {
        NonGen iOb;

        iOb = new NonGen(88);
        iOb.showType();
        int v = (Integer) iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        NonGen strOb = new NonGen("Non-Generics Test");

        strOb.showType();

        String str = (String) strOb.getob();
        System.out.println("value: " + str);

        // This compiles, but is conceptually wrong! 
        iOb = strOb;
        // run-time error! 
        v = (Integer) iOb.getob();
    }
}