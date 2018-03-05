package generics._09_Wildcards;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {
        // If the actual array type is Apple [], you should only be able to place an Apple or a subtype of Apple into the array
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            // ArrayStoreException
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println("1: " + e);
        }
        try {
            // Compiler allows you to add Oranges:
            // ArrayStoreException
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println("2: " + e);
        }
        try {
            // Compiler allows you to add Oranges:
            // ArrayStoreException
            fruit[0] = new Jonathan();
        } catch (Exception e) {
            System.out.println("3: " + e);
        }
    }
}