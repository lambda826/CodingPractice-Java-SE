package generics._03_GenericMethods;

import java.util.List;
import java.util.Map;

import common.typeInfo.pet.Person;
import common.typeInfo.pet.Pet;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
