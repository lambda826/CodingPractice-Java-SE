package enumerations;

// The motivation for inheriting from an enum comes partly from wanting to extend the number of elements in the original enum, and partly from wanting to create subcategories by using subtypes
public interface Food_EnumsInterface {
    enum Appetizer implements Food_EnumsInterface {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food_EnumsInterface {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food_EnumsInterface {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food_EnumsInterface {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}