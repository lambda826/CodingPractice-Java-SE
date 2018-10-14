package oop.polymorphism;

import static utils.Print.*;

class Meal {
    
    Meal() {
        print("Meal()");
    }
    
}

class Bread {
    
    Bread() {
        print("Bread()");
    }
    
}

class Cheese {
    
    Cheese() {
        print("Cheese()");
    }
    
}

class Lettuce {
    
    Lettuce() {
        print("Lettuce()");
    }
    
}

class Lunch extends Meal {
    
    Lunch() {
        print("Lunch()");
    }
    
}

class PortableLunch extends Lunch {
    
    PortableLunch() {
        print("PortableLunch()");
    }
    
}

public class _104_Sandwich extends PortableLunch {
    
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public _104_Sandwich() {
        print("Sandwich()");
    }

    public static void main(String[] args) {
        new _104_Sandwich();
    }
    
}