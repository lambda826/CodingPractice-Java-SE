/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 5:47:07 PM
 */

package generics;

class NonGen32 {
    int num;

    NonGen32(int i) {
        num = i;
    }

    int getnum() {
        return num;
    }
}

class Gen3<T> extends NonGen32 {
    T ob;

    Gen3(T o, int i) {
        super(i);
        ob = o;
    }

    T getob() {
        return ob;
    }
}

public class _214_HierDemo2 {
    public static void main(String args[]) {

        Gen3<String> w = new Gen3<String>("Hello", 47);

        System.out.print(w.getob() + " ");
        System.out.println(w.getnum());
    }
}