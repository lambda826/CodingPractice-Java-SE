//: net/mindview/util/Enums.java
package enumerations._04_useEnum;

import java.util.*;

public class RandomGenerator {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}