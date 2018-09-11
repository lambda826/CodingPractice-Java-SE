package generics;

import java.util.Iterator;
import java.util.Random;

import common.obj.coffee.Americano;
import common.obj.coffee.Breve;
import common.obj.coffee.Cappuccino;
import common.obj.coffee.Coffee;
import common.obj.coffee.Latte;
import common.obj.coffee.Mocha;

/*
 * The parameterized Generator interface ensures that next() returns the parameter type
 * CoffeeGenerator also implements the Iterable interface, so it can be used in a foreach statement
 */
public class _110_CoffeeGenerator implements _109_Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class, };
    private static Random rand = new Random(47);

    // For iteration:
    private int size = 0;

    public _110_CoffeeGenerator() {
    }

    public _110_CoffeeGenerator(int size) {
        this.size = size;
    }

    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return _110_CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    };

    public static void main(String[] args) {
        _110_CoffeeGenerator gen = new _110_CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new _110_CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}