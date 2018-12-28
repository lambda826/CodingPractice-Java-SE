package string;

import java.util.*;

public class _04_UsingStringBuilder {

    public static Random rand = new Random(47);

    //  if looping is involved, you should explicitly use a StringBuilder in your toString()
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
        _04_UsingStringBuilder usb = new _04_UsingStringBuilder();
        System.out.println(usb);
    }

}