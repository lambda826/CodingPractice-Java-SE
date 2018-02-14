/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:47:37 AM
 */

package lambda;

import java.util.ArrayList;
import java.util.Collections;

/*



 */

class MyClass {
    private int val;

    MyClass(int v) {
        val = v;
    }

    int getVal() {
        return val;
    }
}

public class _114_UseMethodRef {
    // A compare() method compatible with the one defined by Comparator<T>. 
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String args[]) {
        ArrayList<MyClass> al = new ArrayList<MyClass>();

        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        // Find the maximum value in al using the compareMC() method. 
        MyClass maxValObj = Collections.max(al, _114_UseMethodRef::compareMC);

        System.out.println("Maximum value is: " + maxValObj.getVal());
    }
}