package others;
/**
 *  @author  Yunxiang He
 *  @date    Jan 12, 2018 11:54:40 AM
 */


/*



 */

public class VarArgs {

    static void vaTest(int... v) {
        System.out.println(v.length);

        for (int x : v) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}
