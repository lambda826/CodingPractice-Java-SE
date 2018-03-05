package generics._03_GenericMethods;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
