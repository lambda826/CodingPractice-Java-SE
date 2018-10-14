package interfaces;

import java.util.*;

public class _117_RandomDoubles {

    private static Random rand = new Random(47);

    public double next() {
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        _117_RandomDoubles rd = new _117_RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.print(rd.next() + " ");
        }
    }

}