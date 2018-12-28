package stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static stream._00_Dish.dishTags;
import static stream._00_Dish.menu;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class _08_Grouping {

    enum CaloricLevel {
        DIET, NORMAL, FAT
    };

    public static void main(String... args) {

        // static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)
        Map<_00_Dish.Type, List<_00_Dish>> groupDishesByType = menu.stream().collect(groupingBy(_00_Dish::getType));
        Map<CaloricLevel, List<_00_Dish>> groupDishesByCaloricLevel = menu.stream().collect(groupingBy(_00_Dish -> {
            if (_00_Dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (_00_Dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));

        // static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
        // static <T, A, R> Collector<T, ?, R> filtering(Predicate<? super T> predicate, Collector<? super T, A, R> downstream)
        Map<_00_Dish.Type, List<_00_Dish>> groupCaloricDishesByType = menu.stream().collect(groupingBy(_00_Dish::getType, filtering(_00_Dish -> _00_Dish.getCalories() > 500, toList())));
        // static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
        Map<_00_Dish.Type, List<String>> groupDishNamesByType = menu.stream().collect(groupingBy(_00_Dish::getType, mapping(_00_Dish::getName, toList())));
        // static <T, U, A, R> Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream)
        Map<_00_Dish.Type, Set<String>> groupDishTagsByType = menu.stream().collect(groupingBy(_00_Dish::getType, flatMapping(_00_Dish -> dishTags.get(_00_Dish.getName()).stream(), toSet())));

        Map<_00_Dish.Type, Map<CaloricLevel, List<_00_Dish>>> groupDishedByTypeAndCaloricLevel = menu.stream().collect(groupingBy(_00_Dish::getType, groupingBy((_00_Dish _00_Dish) -> {
            if (_00_Dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (_00_Dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));

        // static <T> Collector<T, ?, Long> counting()
        Map<_00_Dish.Type, Long> countDishesInGroups = menu.stream().collect(groupingBy(_00_Dish::getType, counting()));

        // static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator)
        Map<_00_Dish.Type, Optional<_00_Dish>> mostCaloricByType = menu.stream().collect(groupingBy(_00_Dish::getType, maxBy(Comparator.comparingInt(_00_Dish::getCalories))));

        // static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher)
        Map<_00_Dish.Type, _00_Dish> mostCaloricByType2 = menu.stream().collect(groupingBy(_00_Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(_00_Dish::getCalories)), Optional::get)));

        // static <T> Collector<T, ?, Optional<T>> reducing(BinaryOperator<T> op)
        Map<_00_Dish.Type, Optional<_00_Dish>> mostCaloricDishesByType = menu.stream().collect(groupingBy(_00_Dish::getType, reducing((_00_Dish d1, _00_Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));

        // static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher)
        Map<_00_Dish.Type, _00_Dish> mostCaloricDishesByTypeWithoutOprionalsMap = menu.stream().collect(groupingBy(_00_Dish::getType, collectingAndThen(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2), Optional::get)));

        // static <T> Collector<T, ?, Integer> summingInt(ToIntFunction<? super T> mapper)
        Map<_00_Dish.Type, Integer> sumCaloriesByType = menu.stream().collect(groupingBy(_00_Dish::getType, summingInt(_00_Dish::getCalories)));

        // static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
        Map<_00_Dish.Type, Set<CaloricLevel>> caloricLevelsByTyp = menu.stream().collect(groupingBy(_00_Dish::getType, mapping(_00_Dish -> {
            if (_00_Dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (_00_Dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, toSet())));

        Map<_00_Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(_00_Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, toCollection(HashSet::new))));
    }
}
