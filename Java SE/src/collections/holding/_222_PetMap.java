package collections.holding;

import static common.utils.Print.print;

import java.util.HashMap;
import java.util.Map;

import common.typeInfo.pet.Cat;
import common.typeInfo.pet.Dog;
import common.typeInfo.pet.Hamster;
import common.typeInfo.pet.Pet;

public class _222_PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
}