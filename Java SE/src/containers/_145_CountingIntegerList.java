package containers;

import java.util.*;

public class _145_CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public _145_CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new _145_CountingIntegerList(30));
    }

}