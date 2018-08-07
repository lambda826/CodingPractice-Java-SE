/**
  @author: Yunxiang He
  @date  : 2018-07-27 01:34
 */

package containers;

import java.util.HashMap;

public class _902_Map {
    // public Interface Map<K,V>
    // V get(Object key)
    // default V getOrDefault(Object key, V defaultValue)
    // V put(K key, V value)
    // void putAll(Map<? extends K,? extends V> m)
    // default V putIfAbsent(K key, V value)
    // V remove(Object key)
    // default boolean remove(Object key, Object value)
    // boolean containsKey(Object key)
    // boolean containsValue(Object value)
    // Set<K> keySet()
    // Collection<V> values()
    // Set<Map.Entry<K,V>> entrySet()
    // int size()
    // boolean isEmpty()
    // void clear()
    // default V replace(K key, V value)
    // default boolean replace(K key, V oldValue, V newValue)
    // default void replaceAll(BiFunction<? super K,? super V,? extends V> function)
    // default V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
    // default V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
    // default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
    // default V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
    // default void forEach(BiConsumer<? super K,? super V> action)
    // boolean equals(Object o)
    // int hashCode()

    // public interface SortedMap<K,V> extends Map<K,V>
    // Comparator<? super K> comparator()
    // K firstKey()
    // K lastKey()
    // SortedMap<K,V> headMap(K toKey)
    // SortedMap<K,V> tailMap(K fromKey)
    // SortedMap<K,V> subMap(K fromKey, K toKey)

    public static void HashMap() {
        // clone()
        HashMap<String, Integer> map = new HashMap<>();
        Object map2 = map.clone();
    }
}
