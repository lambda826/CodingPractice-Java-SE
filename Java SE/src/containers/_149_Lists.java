package containers;

import static utils.Print.print;
import static utils.Print.printnb;

// Things you can do with Lists.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _149_Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        // Add a collection:
        a.addAll(_144_Countries.names(25));
        // Add a collection starting at location 3:
        a.addAll(3, _144_Countries.names(25));
        b = a.contains("1");
        b = a.containsAll(_144_Countries.names(25));
        // Lists allow random access, which is cheap for ArrayList, expensive for LinkedList:
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        a.remove(1);
        // Remove this object
        a.remove("3");
        a.set(1, "y");
        // Keep everything that's in the argument (the intersection of the two sets):
        a.retainAll(_144_Countries.names(25));
        // Remove everything that's in the argument:
        a.removeAll(_144_Countries.names(25));
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element after the newly produced one:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        print(a);
        List<String> b = _144_Countries.names(25);
        print("b = " + b);
        a.addAll(b);
        a.addAll(b);
        print(a);
        // Insert, remove, and replace elements using a ListIterator:
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious())
            printnb(x.previous() + " ");
        print();
        print("testVisual finished");
    }

    // There are some things that only LinkedLists can do:
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(_144_Countries.names(25));
        print(ll);
        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        print(ll);
        // Like "peeking" at the top of a stack:
        print(ll.getFirst());
        // Like popping a stack:
        print(ll.removeFirst());
        print(ll.removeFirst());
        // Treat it like a queue, pulling elements off the tail end:
        print(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(new LinkedList<String>(_144_Countries.names(25)));
        basicTest(new ArrayList<String>(_144_Countries.names(25)));
        iterMotion(new LinkedList<String>(_144_Countries.names(25)));
        iterMotion(new ArrayList<String>(_144_Countries.names(25)));
        iterManipulation(new LinkedList<String>(_144_Countries.names(25)));
        iterManipulation(new ArrayList<String>(_144_Countries.names(25)));
        testVisual(new LinkedList<String>(_144_Countries.names(25)));
        testLinkedList();
    }
}