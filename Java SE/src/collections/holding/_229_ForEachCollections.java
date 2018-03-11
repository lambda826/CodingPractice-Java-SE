package collections.holding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class _229_ForEachCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs)
            System.out.print("'" + s + "' ");
    }
}