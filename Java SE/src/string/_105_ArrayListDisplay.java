package string;

import java.util.ArrayList;

import generics._02_GenericInterfaces.CoffeeGenerator;
import generics._02_GenericInterfaces.coffee.Coffee;

public class _105_ArrayListDisplay {

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        for (Coffee c : new CoffeeGenerator(10)) {
            coffees.add(c);
        }
        System.out.println(coffees);
    }
}