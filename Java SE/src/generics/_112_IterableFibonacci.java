package generics;

import java.util.Iterator;

public class _112_IterableFibonacci extends _111_Fibonacci implements Iterable<Integer> {

    private int n;

    public _112_IterableFibonacci(int count) {
        n = count;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return _112_IterableFibonacci.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new _112_IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}