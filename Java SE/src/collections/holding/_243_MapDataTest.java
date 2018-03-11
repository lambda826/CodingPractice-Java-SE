package collections.holding;

import static common.utils.Print.print;

import java.util.Iterator;

import common.utils.CountingGenerator;
import common.utils.RandomGenerator;
import generics._02_GenericInterfaces.Generator;

class Letters implements Generator<_241_Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    public _241_Pair<Integer, String> next() {
        return new _241_Pair<Integer, String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public Integer next() {
                return number++;
            }

            public boolean hasNext() {
                return number < size;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class _243_MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        print(_242_MapData.map(new Letters(), 11));
        // Two separate generators:
        print(_242_MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
        // A key Generator and a single value:
        print(_242_MapData.map(new CountingGenerator.Character(), "Value", 6));
        // An Iterable and a value Generator:
        print(_242_MapData.map(new Letters(), new RandomGenerator.String(3)));
        // An Iterable and a single value:
        print(_242_MapData.map(new Letters(), "Pop"));
    }
}
