package string;

import java.util.*;

public class _106_InfiniteRecursion {

    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<_106_InfiniteRecursion> v = new ArrayList<_106_InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            v.add(new _106_InfiniteRecursion());
        }
        System.out.println(v);
    }
}
