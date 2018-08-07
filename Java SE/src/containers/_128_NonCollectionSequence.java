package containers;

import java.util.Iterator;

import common.typeInfo.pet.Pet;
import common.typeInfo.pet.Pets;

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class _128_NonCollectionSequence extends PetSequence {
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
        _128_NonCollectionSequence nc = new _128_NonCollectionSequence();
        _126_InterfaceVsIterator.display(nc.iterator());
    }
}