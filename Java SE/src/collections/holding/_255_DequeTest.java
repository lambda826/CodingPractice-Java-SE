package collections.holding;

import static common.utils.Print.print;
import static common.utils.Print.printnb;

public class _255_DequeTest {
    static void fillTest(_254_Deque<Integer> deque) {
        for (int i = 20; i < 27; i++)
            deque.addFirst(i);
        for (int i = 50; i < 55; i++)
            deque.addLast(i);
    }

    public static void main(String[] args) {
        _254_Deque<Integer> di = new _254_Deque<Integer>();
        fillTest(di);
        print(di);
        while (di.size() != 0)
            printnb(di.removeFirst() + " ");
        print();
        fillTest(di);
        while (di.size() != 0)
            printnb(di.removeLast() + " ");
    }
}