package stream;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _00_Dish {

  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;

  public _00_Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return name;
  }

  public enum Type {
    MEAT,
    FISH,
    OTHER
  }

  public static final List<_00_Dish> menu = asList(
      new _00_Dish("pork", false, 800, _00_Dish.Type.MEAT),
      new _00_Dish("beef", false, 700, _00_Dish.Type.MEAT),
      new _00_Dish("chicken", false, 400, _00_Dish.Type.MEAT),
      new _00_Dish("french fries", true, 530, _00_Dish.Type.OTHER),
      new _00_Dish("rice", true, 350, _00_Dish.Type.OTHER),
      new _00_Dish("season fruit", true, 120, _00_Dish.Type.OTHER),
      new _00_Dish("pizza", true, 550, _00_Dish.Type.OTHER),
      new _00_Dish("prawns", false, 400, _00_Dish.Type.FISH),
      new _00_Dish("salmon", false, 450, _00_Dish.Type.FISH)
  );

  public static final Map<String, List<String>> dishTags = new HashMap<>();
  static {
    dishTags.put("pork", asList("greasy", "salty"));
    dishTags.put("beef", asList("salty", "roasted"));
    dishTags.put("chicken", asList("fried", "crisp"));
    dishTags.put("french fries", asList("greasy", "fried"));
    dishTags.put("rice", asList("light", "natural"));
    dishTags.put("season fruit", asList("fresh", "natural"));
    dishTags.put("pizza", asList("tasty", "salty"));
    dishTags.put("prawns", asList("tasty", "roasted"));
    dishTags.put("salmon", asList("delicious", "fresh"));
  }

}
