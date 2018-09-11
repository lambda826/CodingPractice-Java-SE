package generics;

import java.util.ArrayList;
import java.util.Collection;

import common.obj.coffee.Coffee;

public class _115_Generators {

    public static <T> Collection<T> fill(Collection<T> coll, _109_Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new _110_CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }

        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new _111_Fibonacci(), 12);
        for (int i : fnumbers) {
            System.out.print(i + ", ");
        }
    }
}