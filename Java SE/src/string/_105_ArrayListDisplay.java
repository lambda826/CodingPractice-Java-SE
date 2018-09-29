package string;

import java.util.ArrayList;

import common.obj.coffee.Coffee;
import generics._110_CoffeeGenerator;

public class _105_ArrayListDisplay {

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        for (Coffee c : new _110_CoffeeGenerator(10)) {
            coffees.add(c);
        }
        System.out.println(coffees);
    }
    
}