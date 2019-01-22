/**
 *  @author Yunxiang He
 *  @date   01/21/2019
 */

package containers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable

*/

public class _905_ArrayDeque {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(10);
        list.add(11);
        list2.add(10);

        // Add element
        deque.add(0); // addLast()
        deque.addFirst(1);
        deque.addLast(2);
        deque.addAll(list);

        // Off element
        deque.offer(3); // offerLast()
        deque.offerFirst(3);
        deque.offerLast(3);

        // Remove element
        deque.remove(); // removeFirst()
        deque.pop(); // removeFirst()
        deque.removeFirst();
        deque.removeLast();
        deque.removeAll(list2);

        // Poll element
        deque.poll(); // pollFirst()
        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque);
    }
}
