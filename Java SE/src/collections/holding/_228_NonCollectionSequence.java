package collections.holding;

import java.util.Iterator;

import common.typeInfo.pet.Pet;
import common.typeInfo.pet.Pets;

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class _228_NonCollectionSequence extends PetSequence {
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
        _228_NonCollectionSequence nc = new _228_NonCollectionSequence();
        _226_InterfaceVsIterator.display(nc.iterator());
    }
}