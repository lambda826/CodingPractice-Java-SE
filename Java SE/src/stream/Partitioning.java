package stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static stream._00_Dish.menu;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Partitioning {

  public static void main(String... args) {
    System.out.println("Dishes partitioned by vegetarian: " + partitionByVegeterian());
    System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
    System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian());
  }

  private static Map<Boolean, List<_00_Dish>> partitionByVegeterian() {
    return menu.stream().collect(partitioningBy(_00_Dish::isVegetarian));
  }

  private static Map<Boolean, Map<_00_Dish.Type, List<_00_Dish>>> vegetarianDishesByType() {
    return menu.stream().collect(partitioningBy(_00_Dish::isVegetarian, groupingBy(_00_Dish::getType)));
  }

  private static Object mostCaloricPartitionedByVegetarian() {
    return menu.stream().collect(
        partitioningBy(_00_Dish::isVegetarian,
            collectingAndThen(
                maxBy(comparingInt(_00_Dish::getCalories)),
                Optional::get)));
  }

}
