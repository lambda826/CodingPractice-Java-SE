package interfaces;

import java.nio.*;
import java.util.*;

public class _118_AdaptedRandomDoubles extends _117_RandomDoubles implements Readable {
    private int count;

    public _118_AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new _118_AdaptedRandomDoubles(7));
        while (s.hasNextDouble()) {
            System.out.print(s.nextDouble() + " ");
        }
    }
}