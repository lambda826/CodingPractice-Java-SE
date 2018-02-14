/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 12:56:18 AM
 */

package exceptions;

/*



 */

class CapsizedException extends Exception {
}

class Transport {
    public int travel() throws CapsizedException {
        return 2;
    };
}

public class _905_Boat {
    public int travel() throws Exception {
        return 4;
    }; // j1

    public static void main(String... distance) throws Exception {
        try {
            System.out.print(new _905_Boat().travel());
        } catch (Exception e) {
            System.out.print(8);
        }
    }
}