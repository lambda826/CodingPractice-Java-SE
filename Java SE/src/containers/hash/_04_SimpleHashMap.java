package containers.hash;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import containers._144_Countries;

public class _04_SimpleHashMap<K, V> extends AbstractMap<K, V> {

    // Choose a prime number for the hash table size, to achieve a uniform distribution:
    static final int SIZE = 997;

    // You can't have a physical array of generics, but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<_02_MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<_02_MapEntry<K, V>>();
        }
        _02_MapEntry<K, V> pair = new _02_MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<_02_MapEntry<K, V>> it = buckets[index].listIterator();
        while (it.hasNext()) {
            _02_MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (_02_MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<_02_MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (_02_MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        _04_SimpleHashMap<String, String> m = new _04_SimpleHashMap<String, String>();
        m.putAll(_144_Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}