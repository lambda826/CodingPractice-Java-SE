/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 11:08:41 AM
 */

package generics.OTHERS;

import generics._103_TwoGen;

public class TwoGenDemo {
    public static void main(String args[]) {

        _103_TwoGen<Integer, String> tgObj = new _103_TwoGen<Integer, String>(88, "Generics");

        tgObj.showTypes();

        int v = tgObj.getob1();
        System.out.println("value: " + v);

        String str = tgObj.getob2();
        System.out.println("value: " + str);
    }
}
