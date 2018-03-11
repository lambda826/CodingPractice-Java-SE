package generics._03_GenericMethods;

import java.util.List;
import java.util.Map;

import common.typeInfo.pet.Person;
import common.typeInfo.pet.Pet;

/*
 * Prior to JDK 7
 * Type inference doesn’t work for anything other than assignment
 * If you pass the result of a method call such as New.map() as an argument to another method, the compiler will not try to perform type inference
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        // Prior to JDK 7, does not compile
        f(New.map());
    }
}