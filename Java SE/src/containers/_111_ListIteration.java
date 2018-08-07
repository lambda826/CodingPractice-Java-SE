package containers;

import java.util.List;
import java.util.ListIterator;

import common.typeInfo.pet.Pet;
import common.typeInfo.pet.Pets;

public class _111_ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();

        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}