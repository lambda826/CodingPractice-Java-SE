/**
 *  @author  Yunxiang He
 *  @date    Feb 6, 2018 2:40:31 AM
 */

package collections.list;

import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();

        l.add("F");
        l.add("G");
        l.add("H");
        l.add("I");
        l.addFirst("A");
        l.addLast("Z");
        l.add(1, "A2");
        System.out.println(l); // [A, A2, F, G, H, I, Z]

        l.remove("F");
        l.remove(2);
        System.out.println(l); // [A, A2, H, I, Z]

        l.removeFirst();
        l.removeLast();
        System.out.println(l); // [A2, H, I]

        String val = l.get(2);
        l.set(2, val + " Changed");
        System.out.println(l); // [A2, H, I Changed]
    }
}
