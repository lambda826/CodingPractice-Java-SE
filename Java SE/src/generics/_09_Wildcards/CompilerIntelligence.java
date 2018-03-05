package generics._09_Wildcards;

import java.util.*;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        // Argument is 'Object'
        flist.contains(new Apple());
        // Argument is 'Object'
        flist.indexOf(new Apple());
    }
}
