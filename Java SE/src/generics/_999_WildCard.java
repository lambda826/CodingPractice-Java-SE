/**
 *  @author Yunxiang He
 *    @date 11/19/2018
 */

package generics;

import java.util.ArrayList;
import java.util.List;

public class _999_WildCard {

    public static void main(String[] args) {
        A1 a1 = null;
        A2 a2 = null;
        A3 a3 = null;
        A4 a4 = null;

        B1 b1 = null;
        B2 b2 = null;
        B3 b3 = null;
        B4 b4 = null;

        C1 c1 = null;
        C2 c2 = null;
        C3 c3 = null;

        D1 d1 = null;
        D2 d2 = null;

        E1 e1 = null;
        E2 e2 = null;
        E3 e3 = null;
        E4 e4 = null;

        List<? extends C2> list = new ArrayList<D1>();
        c2 = list.get(0);
        List<? super C2> list2 = new ArrayList<>();
        list2.add(d1);
        
    }
}

interface A1 {
}

interface A2 {
}

interface A3 {
}

interface A4 {
}

interface B1 extends A1 {
}

interface B2 extends A1, A2 {
}

interface B3 extends A3, A4 {
}

interface B4 extends A4 {
}

interface C1 extends B2 {
}

interface C2 extends B2, B3 {
}

interface C3 extends B3 {
}

interface D1 extends C1, C2 {
}

interface D2 extends C2 {
}

interface E1 extends D1 {
}

interface E2 extends D1 {
}

interface E3 extends D2 {
}

interface E4 extends D2 {
}