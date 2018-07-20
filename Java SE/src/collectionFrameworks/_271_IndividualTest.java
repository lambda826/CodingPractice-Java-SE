package collectionFrameworks;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import common.typeInfo.pet.Pet;

public class _271_IndividualTest {
    public static void main(String[] args) {
        Set<_270_Individual> pets = new TreeSet<_270_Individual>();
        for (List<? extends Pet> lp : _123_MapOfList.petPeople.values())
            for (Pet p : lp)
                pets.add(p);
        System.out.println(pets);
    }
}