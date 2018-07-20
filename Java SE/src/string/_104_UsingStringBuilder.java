package string;

import java.util.*;

public class _104_UsingStringBuilder {
    public static Random rand = new Random(47);

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        _104_UsingStringBuilder usb = new _104_UsingStringBuilder();
        System.out.println(usb);
    }
}