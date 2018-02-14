/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:11:40 AM
 */

package exceptions;

class BigCat {
    void roar(int level) throws RuntimeException { // m1
        if (level < 3)
            throw new IllegalArgumentException("Incomplete");
        System.out.print("Roar!");
    }
}

public class _907_Lion extends BigCat {
    public void roar() { // m2
        System.out.print("Roar!!!");
    }

    public static void main(String[] cubs) {
        final BigCat kitty = new _907_Lion(); // m3
        kitty.roar(2);
    }
}