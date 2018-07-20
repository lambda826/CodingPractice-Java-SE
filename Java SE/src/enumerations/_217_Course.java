//: enumerated/menu/Course.java
package enumerations;

import enumerations._04_useEnum.RandomGenerator;

public enum _217_Course {
    APPETIZER(Food_EnumsInterface.Appetizer.class), MAINCOURSE(Food_EnumsInterface.MainCourse.class), DESSERT(Food_EnumsInterface.Dessert.class), COFFEE(Food_EnumsInterface.Coffee.class);
    private Food_EnumsInterface[] values;

    private _217_Course(Class<? extends Food_EnumsInterface> kind) {
        values = kind.getEnumConstants();
    }

    public Food_EnumsInterface randomSelection() {
        return RandomGenerator.random(values);
    }
}
