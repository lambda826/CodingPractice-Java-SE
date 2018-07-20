//: enumerated/menu/Meal2.java
package enumerations;

import enumerations._04_useEnum.RandomGenerator;

public enum _220_Meal2 {
    APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class), COFFEE(Food.Coffee.class);
    private Food[] values;

    private _220_Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
        }
    }

    public Food randomSelection() {
        return RandomGenerator.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (_220_Meal2 meal : _220_Meal2.values()) {
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
} /* Same output as Meal.java *///:~
