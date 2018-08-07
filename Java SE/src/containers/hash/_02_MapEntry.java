/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-28 20:06
 */

package containers.hash;

import java.util.Map;

public class _02_MapEntry<K, V> implements Map.Entry<K, V> {
    
    private K key;
    private V value;

    public _02_MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof _02_MapEntry)) {
            return false;
        }
        _02_MapEntry me = (_02_MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) && (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    public String toString() {
        return key + "=" + value;
    }
}