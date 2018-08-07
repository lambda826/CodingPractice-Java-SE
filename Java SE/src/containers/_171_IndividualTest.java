package containers;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import common.typeInfo.pet.Pet;
import containers.hash._07_Individual;

public class _171_IndividualTest {
    public static void main(String[] args) {
        Set<_07_Individual> pets = new TreeSet<_07_Individual>();
        for (List<? extends Pet> lp : _123_MapOfList.petPeople.values())
            for (Pet p : lp)
                pets.add(p);
        System.out.println(pets);
    }
}