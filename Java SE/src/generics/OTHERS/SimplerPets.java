package generics.OTHERS;

import typeinfo.pets.*;
import java.util.*;

import common.typeInfo.pet.Person;
import common.typeInfo.pet.Pet;
import generics._03_GenericMethods._114_New;
import util.*;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = _114_New.map();
        // Rest of the code is the same...
    }
} ///:~
