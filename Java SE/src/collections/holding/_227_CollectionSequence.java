package collections.holding;

import java.util.AbstractCollection;
import java.util.Iterator;

import common.typeInfo.pet.Pet;
import common.typeInfo.pet.Pets;

public class _227_CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.createArray(8);

    public int size() {
        return pets.length;
    }

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public Pet next() {
                return pets[index++];
            }

            public void remove() {
                // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        _227_CollectionSequence c = new _227_CollectionSequence();
        _226_InterfaceVsIterator.display(c);
        _226_InterfaceVsIterator.display(c.iterator());
    }
}