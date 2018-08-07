package containers;

import java.util.AbstractCollection;
import java.util.Iterator;

import common.typeInfo.pet.Pet;
import common.typeInfo.pet.Pets;

public class _127_CollectionSequence extends AbstractCollection<Pet> {
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
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        _127_CollectionSequence c = new _127_CollectionSequence();
        _126_InterfaceVsIterator.display(c);
        _126_InterfaceVsIterator.display(c.iterator());
    }
}