package collectionFrameworks;

import java.util.*;

public class _245_CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public _245_CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new _245_CountingIntegerList(30));
    }
}